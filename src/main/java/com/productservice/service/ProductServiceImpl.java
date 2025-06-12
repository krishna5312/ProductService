package com.productservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.productservice.client.ProductsClient;
import com.productservice.client.exceptions.ProductNotFoundException;
import com.productservice.client.model.Category;
import com.productservice.client.model.Product;
import com.productservice.dto.CategoryDTO;
import com.productservice.dto.ProductDto;

@Component
public class ProductServiceImpl implements ProductService {

	private ProductsClient productsClient;

	public ProductServiceImpl(ProductsClient productsClient) {
		this.productsClient = productsClient;
	}

	@Override
	public List<ProductDto> getProducts() {
		List<Product> products=productsClient.getProducts();
		List<ProductDto> resultProducts= new ArrayList<>();
		if(!CollectionUtils.isEmpty(products)) {
			products.stream().forEach(prod->resultProducts.add(convertToProductDto(prod)));
		}
		
		
		return resultProducts;
	}

	private ProductDto convertToProductDto(Product prod) {
		ProductDto dto = new ProductDto();
		dto.setCategory(prod.getCategory().getName());
		dto.setDescription(prod.getDescription());
		dto.setImage(prod.getImage());
		dto.setId(prod.getId());
		dto.setPrice(prod.getPrice());
		dto.setTitle(prod.getTitle());
		return dto;
	}
	
	@Override
	public ProductDto getProductById(Long id) throws ProductNotFoundException {
		Product product = productsClient.getProductById(id);
		return convertToProductDto(product);
	}
	
	@Override
	public ProductDto updateProductById(Long id,ProductDto dto) throws ProductNotFoundException {
		Product product = productsClient.updateProductById(id, dto);
		return convertToProductDto(product);
	}
	
	@Override
	public ProductDto deleteProductById(Long id) throws ProductNotFoundException {
		Product product = productsClient.deleteProductById(id);
		return convertToProductDto(product);
	}
	
	@Override
	public ProductDto createProduct(ProductDto dto) throws ProductNotFoundException {
		Product product = productsClient.createProduct(dto);
		return convertToProductDto(product);
	}
	
	@Override
	public List<CategoryDTO> getAllCategories(){
		List<CategoryDTO> dtos = new ArrayList<>();
		List<Category> categories =productsClient.getCategories();
		categories.forEach(category -> {
			dtos.add(covertToDto(category));
		});
		return dtos;
	}

	private CategoryDTO covertToDto(Category category) {
		CategoryDTO dto = new CategoryDTO();
		dto.setName(category.getName());
		return dto;
	}

	@Override
	public List<ProductDto> getProductsByCategory(String categoryName) {
		List<ProductDto> resultProducts= new ArrayList<>();
		List<Product> productsOfCategory=productsClient.getProductsByCategory(categoryName);
		if(!CollectionUtils.isEmpty(productsOfCategory)) {
			productsOfCategory.stream().forEach(product ->{
				 resultProducts.add(convertToProductDto(product));
			});
		}
		return null;
	}

}
