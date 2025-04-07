package com.productservice.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.productservice.client.exceptions.ProductNotFoundException;
import com.productservice.client.model.FakeStoreProduct;
import com.productservice.dto.ProductDto;

@Component
public class ProductsClient {
	
    private final String specificProductUrl;

    private final String genericProductUrl;
    
    private RestClient restClient;

    @Autowired
    public ProductsClient(RestClient.Builder builder, @Value("${fakestore.api.url}") String fakeStoreUrl,
            @Value("${fakestore.api.paths.products}") String pathForProducts) {
        this.specificProductUrl = fakeStoreUrl + pathForProducts +"/{id}";
		this.genericProductUrl = fakeStoreUrl + pathForProducts;
		this.restClient= builder.build();
    }
    
    public FakeStoreProduct getProductById(Long id) throws ProductNotFoundException {
        //Integrate the FakeStore API.
        //RestTemplate

    	FakeStoreProduct product= restClient.get()
                .uri(specificProductUrl,id)
                .retrieve()
                .body(FakeStoreProduct.class);

        if (product == null) {
            //Throw an exception.
            throw new ProductNotFoundException("Product with id : " + id + " doesn't exist.");
            //return null;
        }

        //Convert FakeStoreProductDto to ProductDto before returning.
        return product;
    }

    public List<FakeStoreProduct> getProducts() {
    	return List.of(restClient.get()
                .uri(genericProductUrl)
                .retrieve()
                .body(FakeStoreProduct[].class));
             

    }

   public FakeStoreProduct deleteProductById(Long id) throws ProductNotFoundException {
	   FakeStoreProduct product= restClient.delete()
               .uri(specificProductUrl,id).
               retrieve().body(FakeStoreProduct.class);

	    return product;
	   
   }
   
	   
	   public FakeStoreProduct createProduct(ProductDto productDto) {
		   
	        FakeStoreProduct createdProduct= restClient.post().uri(genericProductUrl).body(productDto).retrieve().body(FakeStoreProduct.class);
	        return createdProduct;
	    }
	   
	   public FakeStoreProduct updateProductById(Long id,ProductDto productDto) {
     
		   FakeStoreProduct updatedProduct= restClient.put().uri(specificProductUrl+ id).body(productDto).retrieve().body(FakeStoreProduct.class);
	        return updatedProduct;

		   
	   }
   }
