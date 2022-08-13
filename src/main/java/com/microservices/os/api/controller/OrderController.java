package com.microservices.os.api.controller;

import com.microservices.os.api.entity.Order;
import com.microservices.os.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/addOrder")
    public Order addOrder(@RequestBody Order order){
        return orderService.saveProduct(order);
    }

    @PostMapping("/addOrders")
    public List<Order> addOrders(@RequestBody List<Order> orders){
        return orderService.saveAllProducts(orders);
    }

    @GetMapping("/orders")
    public List<Order> findAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/orderById/{id}")
    public Optional<Order> findOrderbyId(@PathVariable int id){
        return orderService.getOrderbyId(id);
    }


    @GetMapping("/order/{name}")
    public Order findOrderByName(@PathVariable String name){
        return orderService.getOrderByName(name);
    }

    @DeleteMapping("/deleteOrderById/{id}")
    public String deleteOrderById(@PathVariable int id){
        return orderService.deleteOrderById(id);
    }

    @PutMapping("/update")
    public Order updateOrder(@RequestBody Order order){
        return orderService.updateOrder(order);
    }

}
