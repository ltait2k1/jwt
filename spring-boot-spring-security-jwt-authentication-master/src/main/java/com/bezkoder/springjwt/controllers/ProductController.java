package com.bezkoder.springjwt.controllers;


import com.bezkoder.springjwt.models.Product;
import com.bezkoder.springjwt.models.responobj.Respon;
import com.bezkoder.springjwt.services.IProductServices;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping(value = "api/version1.0")
public class ProductController {
    @Autowired
    private IProductServices productServices;

    @GetMapping(value = "product/getall/{pageNumber}/{pageSize}/{sortType}/{field}")
    public List<Product> getAll(@PathVariable int pageNumber, @PathVariable int pageSize, @PathVariable() String field, @PathVariable Boolean sortType)
    {
        return productServices.getAllProduct(pageNumber,pageSize, field, sortType);
    }

    @GetMapping(value = "product/getall/{pageNumber}/{pageSize}/{sortType}")
    public List<Product> getAll(@PathVariable int pageNumber, @PathVariable int pageSize,@PathVariable Boolean sortType)
    {
        return productServices.getAllProduct(pageNumber,pageSize,null, sortType);
    }

    @PostMapping(value = "product/create")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public Respon<Product> createProduct(@RequestBody String product)
    {
        Gson gson = new Gson();
        Product productNew = gson.fromJson(product,Product.class);
        return productServices.creatProduct(productNew);
    }
    @PutMapping(value = "product/update")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public Respon<Product> updateProduct(@RequestBody String product)
    {
        Gson gson = new Gson();
        Product productNew = gson.fromJson(product,Product.class);
        return productServices.updatePrduct(productNew);
    }
    @DeleteMapping(value = "product/delete")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public  Respon<Product> deleteProDuct(@RequestParam int idProduct)
    {
        return productServices.delete(idProduct);
    }

    @GetMapping(value = "product/seach/{pageNumber}/{pageSize}")
    public ResponseEntity<Page<Product>> seachProduct(@RequestParam String name,@PathVariable int pageNumber,@PathVariable int pageSize)
    {
        return productServices.seachProduct(name,pageNumber,pageSize);
    }
    @GetMapping(value = "product/seachprice/{pageNumber}/{pageSize}")
    public Page<Product> seachPriceProduct(@RequestParam int value1, @RequestParam int value2, @PathVariable int pageNumber, @PathVariable int pageSize)
    {
        return productServices.seachByPrice(value1,value2,pageNumber,pageSize);
    }

    @GetMapping(value = "product/viewProduct/{idProduct}")
    public Product viewProduct(@PathVariable int idProduct){
        return productServices.viewProduct(idProduct);
    }
}
