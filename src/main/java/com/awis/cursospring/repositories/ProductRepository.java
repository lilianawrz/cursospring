package com.awis.cursospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awis.cursospring.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
