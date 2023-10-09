package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.ProductImage;
import com.bezkoder.springjwt.models.responobj.Respon;
import com.bezkoder.springjwt.services.IProductImageServices;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(originPatterns = "http://localhost:8080")

@RestController
@RequestMapping(value = "api/version1.0")
public class ProductImageController {
    @Autowired
    private IProductImageServices productImageServices;

    @PostMapping(value = "productImage/addProductImage")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public Respon<ProductImage> addProductImage(@RequestBody String productImageNew){
        Gson gson = new Gson();
        ProductImage productImage = gson.fromJson(productImageNew, ProductImage.class);
        return productImageServices.addProductImage(productImage);
    }

    @PutMapping(value = "productImage/updateProductImage")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public Respon<ProductImage> updateProducImage(@RequestBody String productImageNew){
        Gson gson = new Gson();
        ProductImage productImage = gson.fromJson(productImageNew, ProductImage.class);
        return productImageServices.updateProductImage(productImage);
    }

    @DeleteMapping(value = "productImage/deleteProductImage")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public Respon<ProductImage> deleteProducImage(@RequestParam int producImageId){
        return productImageServices.deleteProductImage(producImageId);
    }
}
