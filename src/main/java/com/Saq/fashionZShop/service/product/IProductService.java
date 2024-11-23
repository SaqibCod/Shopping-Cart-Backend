package com.Saq.fashionZShop.service.product;

import com.Saq.fashionZShop.model.Product;
import com.Saq.fashionZShop.request.AddProductRequest;
import com.Saq.fashionZShop.request.UpdateProductRequest;

import java.util.List;

public interface IProductService {
    Product addProduct(AddProductRequest request);
    Product getProductById(Long product_id);
    void deleteProductById(Long product_id);
    Product updateProduct(UpdateProductRequest product, Long product_id);
    List<Product> getAllProduct();
    List<Product> getProductByCategory(String category);
    List<Product> getProductByBrand(String brand);
    List<Product> getProductByCategoryAndBrand(String category, String brand);
    List<Product> getProductByName(String name);
    List<Product> getProductByBrandAndName(String brand, String name);
    Long countProductsByBrandAndName(String brand, String name);
}
