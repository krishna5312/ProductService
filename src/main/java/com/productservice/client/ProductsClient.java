package com.productservice.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.productservice.client.exceptions.ProductNotFoundException;
import com.productservice.client.model.Category;
import com.productservice.client.model.Product;
import com.productservice.dto.ProductDto;

@Component
public class ProductsClient {
	
    private final String specificProductUrl;

    private final String genericProductUrl;
    
    private final String categoryUrl;
    
    private RestClient restClient;

    @Autowired
    public ProductsClient(RestClient.Builder builder, @Value("${fakestore.api.url}") String fakeStoreUrl,
            @Value("${fakestore.api.paths.products}") String pathForProducts , @Value("${fakestore.api.paths.categories}") String pathForCategories) {
        this.specificProductUrl = fakeStoreUrl + pathForProducts +"/{id}";
		this.genericProductUrl = fakeStoreUrl + pathForProducts;
		this.restClient= builder.build();
		this.categoryUrl = fakeStoreUrl+pathForCategories;
    }
    
    public Product getProductById(Long id) throws ProductNotFoundException {
        //Integrate the FakeStore API.
        //RestTemplate

    	Product product= restClient.get()
                .uri(specificProductUrl,id)
                .retrieve()
                .body(Product.class);

        if (product == null) {
            //Throw an exception.
            throw new ProductNotFoundException("Product with id : " + id + " doesn't exist.");
            //return null;
        }

        //Convert FakeStoreProductDto to ProductDto before returning.
        return product;
    }

    public List<Product> getProducts() {
    	return List.of(restClient.get()
                .uri(genericProductUrl)
                .retrieve()
                .body(Product[].class));
             

    }

   public Product deleteProductById(Long id) throws ProductNotFoundException {
	   return restClient.delete()
               .uri(specificProductUrl,id).
               retrieve().body(Product.class);
	   
   }
   
	   
	   public Product createProduct(ProductDto productDto) {
		   
	        Product createdProduct= restClient.post().uri(genericProductUrl).body(productDto).retrieve().body(Product.class);
	        return createdProduct;
	    }
	   
	   public Product updateProductById(Long id,ProductDto productDto) {
     
		   Product updatedProduct= restClient.put().uri(specificProductUrl+ id).body(productDto).retrieve().body(Product.class);
	        return updatedProduct;

	   }
	   
	   public List<Product> getProductsByCategory(String category){
		   return List.of(restClient.get().uri(categoryUrl+category).retrieve().body(Product[].class));
		   
	   }
	   
	   public List<Category> getCategories(){
		   return List.of(restClient.get().uri(categoryUrl).retrieve().body(com.productservice.client.model.Category[].class));
	   }
   }
