package com.productservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productservice.client.exceptions.ProductNotFoundException;
import com.productservice.dto.CategoryDTO;
import com.productservice.dto.ProductDto;
import com.productservice.service.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {
	
	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService=productService;
	}
	
	@GetMapping
	public ResponseEntity<List<ProductDto>> getProducts(){
		return new ResponseEntity<List<ProductDto>>(productService.getProducts(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto dto) throws ProductNotFoundException{
		return new ResponseEntity<ProductDto>(productService.createProduct(dto),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable long id) throws ProductNotFoundException{
		return new ResponseEntity<ProductDto>(productService.getProductById(id),HttpStatus.FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProductDto> updateProductById(@PathVariable long id, @RequestBody ProductDto dto) throws ProductNotFoundException{
		return new ResponseEntity<ProductDto>(productService.updateProductById(id,dto),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ProductDto> deleteProductById(@PathVariable long id) throws ProductNotFoundException{
		return new ResponseEntity<ProductDto>(productService.deleteProductById(id),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/categories")
	public ResponseEntity<List<CategoryDTO>> getAllCategories(){
		return new ResponseEntity<List<CategoryDTO>>(productService.getAllCategories(),HttpStatus.OK);
		
	}
	
	@GetMapping("/categories/{category}")
	public ResponseEntity<List<ProductDto>> getProductsByCategory(@PathVariable String category){
		return new ResponseEntity<List<ProductDto>>(productService.getProductsByCategory(category), HttpStatus.OK);
	}

}
