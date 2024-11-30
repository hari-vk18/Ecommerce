package com.mine.ecom_pro.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mine.ecom_pro.model.Product;
import com.mine.ecom_pro.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo repo;

	public List<Product> getProducts() {
		return repo.findAll();
	}

	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
		// TODO Auto-generated method stub

		product.setImageName(imageFile.getOriginalFilename());
		product.setImageData(imageFile.getBytes());
		product.setImageType(imageFile.getContentType());
		return repo.save(product);
	}

	public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
		// TODO Auto-generated method stub
		product.setImageName(imageFile.getOriginalFilename());
		product.setImageData(imageFile.getBytes());
		product.setImageType(imageFile.getContentType());
		return repo.save(product);
	}

	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);

	}

	public List<Product> searchProducts(String keyword) {
		// TODO Auto-generated method stub
		return repo.searchProducts(keyword);
	}

}
