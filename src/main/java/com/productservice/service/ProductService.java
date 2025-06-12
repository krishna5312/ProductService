package com.productservice.service;

import java.util.List;

import com.productservice.client.exceptions.ProductNotFoundException;
import com.productservice.dto.CategoryDTO;
import com.productservice.dto.ProductDto;

public interface ProductService {

	List<ProductDto> getProducts();

	ProductDto getProductById(Long id) throws ProductNotFoundException;

	ProductDto updateProductById(Long id, ProductDto dto) throws ProductNotFoundException;

	ProductDto deleteProductById(Long id) throws ProductNotFoundException;

	ProductDto createProduct(ProductDto dto) throws ProductNotFoundException;

	List<CategoryDTO> getAllCategories();
	
	List<ProductDto> getProductsByCategory(String categoryName);
}
