package com.ashish.shoppingConsumer.listener;


import com.ashish.shoppingConsumer.event.Order;
import com.ashish.shoppingConsumer.event.User;
import com.ashish.shoppingConsumer.repository.OrderRepository;
import com.ashish.shoppingConsumer.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderNotificationListener {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;



    @KafkaListener(topics = "order-topic", groupId = "foo")
    public void listenGroup(String message){
        System.out.println("Received Message in group foo: " + message);
        ObjectMapper object = new ObjectMapper();
        Order order = null;
        try {
            order = object.readValue(message, Order.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        User user = userRepository.findById(order.getUserId()).get();
        if (user.getBalance() > order.getOrderAmount()) {
            user.setBalance(user.getBalance() - order.getOrderAmount());
            order.setStatus("SUCCESS");
            userRepository.save(user);
            orderRepository.save(order);
        } else {
            order.setStatus("FAILED");
            orderRepository.save(order);
        }

    }

}
