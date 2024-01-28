package com.project.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.product.entity.Product;
import com.project.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
@Autowired
private ProductService service;
@PostMapping("/add")
public Product addProduct(@RequestBody Product product)
{
	return service.saveProduct(product);
}
@PostMapping("/adds")
public List<Product> addProducts(@RequestBody List<Product> products)
{
	return service.saveProducts(products);
}
@GetMapping("/getid/{id}")
public Product getProductId(@PathVariable int id)
{
	return service.getProductById(id);
}
@GetMapping
public List<Product> getAll(){
	return service.getProducts();
}
@GetMapping("/getname/{name}")
public Product getProductName(@PathVariable String name)
{
	return service.getProductByName(name);
}
@PutMapping("/update")
public Product updateProducts(@RequestBody Product product){
	return service.updateProduct(product);
}
@DeleteMapping("/delete/{id}")
public String deleteProduct(@PathVariable int id)
{
	return service.deleteById(id);
}
}
