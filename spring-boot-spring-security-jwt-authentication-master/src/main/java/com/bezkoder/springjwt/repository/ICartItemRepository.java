package com.bezkoder.springjwt.repository;


import com.bezkoder.springjwt.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartItemRepository extends JpaRepository<CartItem, Integer> {
}
