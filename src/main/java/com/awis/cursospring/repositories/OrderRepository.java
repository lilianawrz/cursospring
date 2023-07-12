package com.awis.cursospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awis.cursospring.entities.Order;
public interface OrderRepository extends JpaRepository<Order, Long>
{

}
