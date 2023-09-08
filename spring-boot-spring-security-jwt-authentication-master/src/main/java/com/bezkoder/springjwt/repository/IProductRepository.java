package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {
    Page<Product> findAllByNameProductContains(String name, Pageable pageable);
    Page<Product> findAllByPriceBetween(int value1, int value2, Pageable pageable);
}
