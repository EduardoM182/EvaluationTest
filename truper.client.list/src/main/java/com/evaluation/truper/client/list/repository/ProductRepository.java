package com.evaluation.truper.client.list.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evaluation.truper.client.list.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
