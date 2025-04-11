package com.example.pspdemo.controller;

import com.example.pspdemo.entity.PaymentOrder;
import com.example.pspdemo.service.BusinessException;
import com.example.pspdemo.service.PaymentOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class PaymentOrderController {

    private final PaymentOrderService service;

    public PaymentOrderController(PaymentOrderService service) {
        this.service = service;
    }

    @PostMapping
    public PaymentOrder createOrder(@RequestBody PaymentOrder order) throws BusinessException {
        return service.createOrder(order);
    }

    @GetMapping
    public List<PaymentOrder> getAllOrders() {
        return service.getAllOrders();
    }

    @GetMapping("/{id}")
    public PaymentOrder getOrderById(@PathVariable Long id) {
        return service.getOrderById(id);
    }

    @PutMapping("/{id}")
    public PaymentOrder updateOrder(@PathVariable Long id, @RequestBody PaymentOrder order) {
        return service.updateOrder(id, order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        service.deleteOrder(id);
    }
}
