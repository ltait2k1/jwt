package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.ProductImage;
import com.bezkoder.springjwt.models.responobj.Respon;


public interface IProductImageServices {
    public Respon<ProductImage> addProductImage(ProductImage productImage);
    public Respon<ProductImage> updateProductImage(ProductImage productImage);
    public Respon<ProductImage> deleteProductImage(int producImageId);
}
