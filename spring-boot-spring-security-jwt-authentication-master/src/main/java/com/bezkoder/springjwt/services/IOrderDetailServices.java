package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.OrderDetail;
import com.bezkoder.springjwt.models.responobj.Respon;


public interface IOrderDetailServices {
    public Respon<OrderDetail> addOrderDetail(OrderDetail orderDetail);
    public Respon<OrderDetail> updateOrderDetail(OrderDetail orderDetail);
}
