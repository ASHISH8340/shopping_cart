package com.ashish.shoppingConsumer.repository;

import com.ashish.shoppingConsumer.event.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
