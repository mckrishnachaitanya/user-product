package com.user.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserProductController {

	@Autowired
	RestTemplate restTemplate;

	@Value("${product-catalog.url}")
	private String productCatalogUrl;

	@RequestMapping(value = "/customer/products/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProducts(@PathVariable("id") long id) {
		return restTemplate.getForEntity(productCatalogUrl + id, Product.class);
	}

	@RequestMapping(value = "/customer/products", method = RequestMethod.POST)
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {

		Product products = restTemplate.postForObject(productCatalogUrl, product, Product.class);
		return ResponseEntity.ok().body(products);
	}

	@RequestMapping(value = "/customer/products/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Product> modifyProduct(@PathVariable long id, @RequestBody Product product) {

		restTemplate.put(productCatalogUrl + id, product, Product.class);
		return ResponseEntity.ok().body(product);
	}

	@RequestMapping(value = "/customer/products/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Product> deleteProduct(@PathVariable long id) {

		restTemplate.delete(productCatalogUrl + id, Product.class);
		return ResponseEntity.ok().body(null);
	}

}
