package com.ashish.shoppingConsumer.repository;

import com.ashish.shoppingConsumer.event.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
}
