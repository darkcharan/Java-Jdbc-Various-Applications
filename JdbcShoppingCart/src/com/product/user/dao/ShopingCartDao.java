package com.product.user.dao;

import java.util.List;

import com.product.bean.Product;

public interface ShopingCartDao {
List<Product> viewAllProducts();
void addCart();
void viewCart();
void updateCart();
void removeCart();
void billGenerate();
}
