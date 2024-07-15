package com.elasticsearch.query.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elasticsearch.model.Product;
import com.elasticsearch.query.ElasticSearchQuery;

@RestController
public class ElasticSearchController {

	@Autowired
	private ElasticSearchQuery elasticSearchQuery;

	@PostMapping("/createOrUpdateDocument")
	public ResponseEntity<Object> createOrUpdateDocument(@RequestBody Product product) throws IOException {
		String response = elasticSearchQuery.createOrUpdateDocument(product);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/getDocument")
	public ResponseEntity<Object> getDocumentById(@RequestParam String productId) throws IOException {
		Product product = elasticSearchQuery.getDocumentById(productId);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@DeleteMapping("/deleteDocument")
	public ResponseEntity<Object> deleteDocumentById(@RequestParam String productId) throws IOException {
		String response = elasticSearchQuery.deleteDocumentById(productId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/searchDocument")
	public ResponseEntity<Object> searchAllDocument() throws IOException {
		List<Product> products = elasticSearchQuery.searchAllDocuments();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
}
