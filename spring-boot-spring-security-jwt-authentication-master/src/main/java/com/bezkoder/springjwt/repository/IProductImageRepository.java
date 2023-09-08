package com.bezkoder.springjwt.repository;


import com.bezkoder.springjwt.models.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductImageRepository extends JpaRepository<ProductImage,Integer> {
}
