package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.Order;
import com.bezkoder.springjwt.models.responobj.Respon;

public interface IOrderServices {
    public Respon<Order> addOrder(int idCart, String fullName, String email, String phone, String address, String note);
    public Order viewOrder(int idOrder);
}
