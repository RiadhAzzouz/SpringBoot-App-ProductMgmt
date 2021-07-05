package org.sid.web;

import java.util.Optional;

import org.sid.dao.CategoryRepository;
import org.sid.dao.ProductRepository;
import org.sid.entities.Category;
import org.sid.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
public class ProductController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	
	
	@PostMapping("/saveProduct")
	public Product saveProduct(@RequestBody ProductForm productForm) {
		
		Optional<Category> c = categoryRepository.findById(productForm.getCategoryId());
		if(c.isPresent()) {
			Product p = productRepository.save(new Product(null, productForm.getName(), productForm.getPrice(), c.get()));
			c.get().getProducts().add(p);
			categoryRepository.save(c.get());
			return p;
		}
		return null;
	}

}

@Data
class ProductForm {
	private String name;
	private Double price;
	private String categoryId;
}
