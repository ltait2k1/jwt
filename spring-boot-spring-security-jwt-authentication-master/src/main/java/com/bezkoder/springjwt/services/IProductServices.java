package com.bezkoder.springjwt.services;


import com.bezkoder.springjwt.models.Product;
import com.bezkoder.springjwt.models.responobj.Respon;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProductServices {
    public List<Product> getAllProduct(int pageNumber, int pageSize, String field, Boolean sortType);
    public Respon<Product> creatProduct(Product product);
    public Respon<Product> updatePrduct(Product product);
    public Respon<Product> delete(int idProduct);
    public ResponseEntity<Page<Product>> seachProduct(String name, int pageNumber, int pageSize);
    public Page<Product> seachByPrice(int value1, int value2, int pageNumber, int pageSize);
    public Product viewProduct(int idProduct);
}
