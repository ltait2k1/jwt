package com.bezkoder.springjwt.services.ipm;


import com.bezkoder.springjwt.repository.ICartItemRepository;
import com.bezkoder.springjwt.services.ICartItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemService implements ICartItemServices {
    @Autowired
    private ICartItemRepository cartItemRepository;
}
