package com.bezkoder.springjwt.controllers;


import com.bezkoder.springjwt.models.ProductType;
import com.bezkoder.springjwt.models.responobj.Respon;
import com.bezkoder.springjwt.services.IProductTypeServices;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(originPatterns = "http://localhost:8080")

@RestController
@RequestMapping(value = "api/version1.0")
public class ProductTypeController {
    @Autowired
    private IProductTypeServices productTypeServices;

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @GetMapping(value = "productType/getAll/{pageNumber}/{pageSize}")
    public Page<ProductType> getAll(@PathVariable int pageNumber, @PathVariable int pageSize){
        return productTypeServices.getAll(pageNumber,pageSize);
    }

    @PostMapping(value = "productType/addProductType")
    public Respon<ProductType> addProductType(@RequestBody String productTypeNew){
        Gson gson = new Gson();
        ProductType productType =gson.fromJson(productTypeNew, ProductType.class);
        return productTypeServices.addProductType(productType);
    }

    @PutMapping(value = "productType/updateProductType")
    public Respon<ProductType> updateProductType(@RequestBody String productTypeNew){
        Gson gson = new Gson();
        ProductType productType =gson.fromJson(productTypeNew, ProductType.class);
        return productTypeServices.updateProductType(productType);
    }

    @DeleteMapping(value = "productType/deleteProductType")
    public Respon<ProductType> deleteProductType(@RequestParam int productTypeId){
        return productTypeServices.deleteProductType(productTypeId);
    }
    @GetMapping(value = "producttype/seach/{pageNumber}/{pageSize}")
    public Page<ProductType> seachProduct(@RequestParam String name, @PathVariable int pageNumber,@PathVariable int pageSize)
    {
        return productTypeServices.seachProduct(name,pageNumber,pageSize);
    }
}
