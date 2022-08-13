package com.microservices.os.api.service;

import com.microservices.os.api.entity.Order;
import com.microservices.os.api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

@Autowired
private OrderRepository orderRepository;

public List<Order> saveAllProducts(List<Order> order){
    return orderRepository.saveAll(order);
}

public Order saveProduct(Order order){
    return orderRepository.save(order);
}

public List<Order> getAllOrders(){
    return orderRepository.findAll();
}

public Optional<Order> getOrderbyId(int id){
    return orderRepository.findById(id);
}

public Order getOrderByName(String name){
    return orderRepository.findByName(name);
}

public String deleteOrderById(int id){
     orderRepository.deleteById(id);
     return "Order is deleted, orderId is : "+id;
}

public Order updateOrder(Order order){
    Order existingOrder = orderRepository.findById(order.getId()).orElse(null);
    existingOrder.setName(existingOrder.getName());
    existingOrder.setPrice(existingOrder.getPrice());
    existingOrder.setQuantity(existingOrder.getQuantity());
    return existingOrder;
}
}
