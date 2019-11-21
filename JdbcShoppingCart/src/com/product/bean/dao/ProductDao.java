package com.product.bean.dao;

import java.util.List;

import com.product.bean.Product;

public interface ProductDao {
	void addProductDetails();
	List<Product>addRecordsviewProductDetails();
	Product viewSpecificProductDetials(int pno);
	
	void updateProductDetials();
	void DeleteProductDetilas();

}
