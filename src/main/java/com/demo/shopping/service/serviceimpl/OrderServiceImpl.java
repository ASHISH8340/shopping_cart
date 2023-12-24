package com.demo.shopping.service.serviceimpl;

import com.demo.shopping.model.Order;
import com.demo.shopping.repositories.OrderRepository;
import com.demo.shopping.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Value("${order.topic.name}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    ObjectMapper om=new ObjectMapper();
    @Override
    public Order createOrder(Order order) {
        order =orderRepository.save(order);
        order.setStatus("CREATED");
        String message=null;
        try {
            message = om.writeValueAsString(order);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        kafkaTemplate.send(topicName,message);
        return order;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
