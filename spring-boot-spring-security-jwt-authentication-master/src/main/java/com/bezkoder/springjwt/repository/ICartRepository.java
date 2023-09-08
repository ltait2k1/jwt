package com.bezkoder.springjwt.repository;


import com.bezkoder.springjwt.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Integer> {
}
