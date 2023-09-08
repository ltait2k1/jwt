package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.CartItem;
import com.bezkoder.springjwt.models.responobj.CartTemp;
import com.bezkoder.springjwt.models.responobj.Respon;


import java.util.List;

public interface ICartServices {
    public Respon<CartItem> addCartItem(int idUser, int idProduct, Integer quantity);
    public List<CartTemp> updateCartItem(int idCartItem, Integer quantity);
    public List<CartTemp> deleteCartItem(int idCartItem);
    public List<CartTemp> deleteAll(int idCart);
    public List<CartTemp> getAll(int idCart);
    public List<CartItem> view(int idCart);
}
