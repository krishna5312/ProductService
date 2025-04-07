package com.productservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.productservice.client.ProductsClient;
import com.productservice.client.exceptions.ProductNotFoundException;
import com.productservice.client.model.FakeStoreProduct;
import com.productservice.dto.ProductDto;

@Component
public class ProductServiceImpl implements ProductService {

	private ProductsClient productsClient;

	public ProductServiceImpl(ProductsClient productsClient) {
		this.productsClient = productsClient;
	}

	@Override
	public List<ProductDto> getProducts() {
		List<FakeStoreProduct> products=productsClient.getProducts();
		List<ProductDto> resultProducts= new ArrayList<>();
		if(!CollectionUtils.isEmpty(products)) {
			products.stream().forEach(prod->resultProducts.add(convertToProductDto(prod)));
		}
		
		
		return resultProducts;
	}

	private ProductDto convertToProductDto(FakeStoreProduct prod) {
		ProductDto dto = new ProductDto();
		dto.setCategory(prod.category());
		dto.setDescription(prod.description());
		dto.setImage(prod.image());
		dto.setId(prod.id());
		dto.setPrice(prod.price());
		dto.setTitle(prod.title());
		if(Objects.nonNull(prod.rating())) {
			dto.setInventoryCount(prod.rating().count());
			dto.setRating(prod.rating().rate());
		}
		return dto;
	}
	
	@Override
	public ProductDto getProductById(Long id) throws ProductNotFoundException {
		FakeStoreProduct product = productsClient.getProductById(id);
		return convertToProductDto(product);
	}
	
	@Override
	public ProductDto updateProductById(Long id,ProductDto dto) throws ProductNotFoundException {
		FakeStoreProduct product = productsClient.updateProductById(id, dto);
		return convertToProductDto(product);
	}
	
	@Override
	public ProductDto deleteProductById(Long id) throws ProductNotFoundException {
		FakeStoreProduct product = productsClient.deleteProductById(id);
		return convertToProductDto(product);
	}
	
	@Override
	public ProductDto createProduct(ProductDto dto) throws ProductNotFoundException {
		FakeStoreProduct product = productsClient.createProduct(dto);
		return convertToProductDto(product);
	}

}
