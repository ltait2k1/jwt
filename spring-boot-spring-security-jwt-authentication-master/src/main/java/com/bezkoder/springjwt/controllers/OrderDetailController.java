package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.OrderDetail;
import com.bezkoder.springjwt.models.responobj.Respon;
import com.bezkoder.springjwt.services.IOrderDetailServices;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(originPatterns = "http://localhost:8080")

@RestController
@RequestMapping(value = "api/version1.0")
public class OrderDetailController {
    @Autowired
    private IOrderDetailServices orderDetailServices;

    @PostMapping(value = "orderDetail/addOrderDetail")
    public Respon<OrderDetail> addOrderDetail(@RequestBody String orderDetailNew){
        Gson gson = new Gson();
        OrderDetail orderDetail = gson.fromJson(orderDetailNew, OrderDetail.class);
        return orderDetailServices.addOrderDetail(orderDetail);
    }
}
