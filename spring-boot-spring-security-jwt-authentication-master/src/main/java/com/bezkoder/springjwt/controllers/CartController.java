package com.bezkoder.springjwt.controllers;


import com.bezkoder.springjwt.models.CartItem;
import com.bezkoder.springjwt.models.responobj.CartTemp;
import com.bezkoder.springjwt.models.responobj.Respon;
import com.bezkoder.springjwt.services.ICartServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(originPatterns = "http://localhost:8080")
@RestController
@RequestMapping(value = "api/version1.0")
public class CartController {
    @Autowired
    private ICartServices cartServices;

    @PostMapping(value = "cart/addCartItem/{idUser}/{idProduct}/{quantity}")
    public Respon<CartItem> addCartItem(@PathVariable int idUser, @PathVariable int idProduct, @PathVariable Integer quantity){
        return cartServices.addCartItem(idUser,idProduct,quantity);
    }

    @PostMapping(value = "cart/addCartItem/{idUser}/{idProduct}")
    public Respon<CartItem> addCartItem(@PathVariable int idUser, @PathVariable int idProduct){
        return cartServices.addCartItem(idUser,idProduct,null);
    }

    @PutMapping(value = "cart/updateCartItem/{idCartItem}/{quantity}")
    public List<CartTemp> updateCartItem(@PathVariable int idCartItem, @PathVariable Integer quantity){
        return cartServices.updateCartItem(idCartItem, quantity);
    }

    @DeleteMapping(value = "cart/deleteCartItem/{idCartItem}")
    public List<CartTemp> deleteCartItem(@PathVariable int idCartItem){
        return cartServices.deleteCartItem(idCartItem);
    }

    @DeleteMapping(value = "cart/deleteAll/{idCart}")
    public List<CartTemp> deleteAll(@PathVariable int idCart){
        return cartServices.deleteAll(idCart);
    }

    @GetMapping(value = "cart/getAll/{idCart}")
    public List<CartTemp> getAllCartItem(@PathVariable int idCart){
        return cartServices.getAll(idCart);
    }

    @GetMapping(value = "cart/view/{idCart}")
    public List<CartItem> view(@PathVariable int idCart){
        return cartServices.view(idCart);
    }
}
