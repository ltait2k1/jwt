package com.bezkoder.springjwt.repository;


import com.bezkoder.springjwt.models.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductReviewRepository extends JpaRepository<ProductReview,Integer> {
}
