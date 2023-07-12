package com.awis.cursospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awis.cursospring.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
