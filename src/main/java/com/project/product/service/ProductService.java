package com.project.product.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.product.entity.Product;
import com.project.product.repository.ProductRepo;

@Service
public class ProductService {
  @Autowired
  private ProductRepo repo;
  //posting a single product
  public Product saveProduct(Product product) {
	  return repo.save(product);
  }
//posting a list of product
  public List<Product> saveProducts(List<Product> products) {
	  return repo.saveAll(products);
  }
//getting a single product using id
  public Product getProductById(int id) {
	  return repo.findById(id).orElse(null);
  }
//getting a list of product
  public List<Product> getProducts() {
	  return repo.findAll();
  }	
//getting a single product using name
  public Product getProductByName(String name) {
	  return repo.findByName(name);
  }
  //deleting product by id
  public String deleteById(int id)
  {
	  repo.deleteById(id);
	  return "deleted successfully";
  }
  //updating product
  public Product updateProduct(Product product)
  {
	  Product extProduct=repo.findById(product.getId()).orElse(null);
	  extProduct.setName(product.getName());
	  extProduct.setQuantity(product.getQuantity());
	  extProduct.setPrice(product.getPrice());
	  return repo.save(extProduct);
  }
}
