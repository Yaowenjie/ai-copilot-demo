package com.example.pspdemo.service;

import com.example.pspdemo.entity.PaymentOrder;
import com.example.pspdemo.repository.PaymentOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentOrderService {

    private final PaymentOrderRepository repository;

    public PaymentOrderService(PaymentOrderRepository repository) {
        this.repository = repository;
    }

    public PaymentOrder createOrder(PaymentOrder order) {
        return repository.save(order);
    }

    public List<PaymentOrder> getAllOrders() {
        return repository.findAll();
    }

    public PaymentOrder getOrderById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public PaymentOrder updateOrder(Long id, PaymentOrder updatedOrder) {
        PaymentOrder existingOrder = getOrderById(id);
        // ...update fields...
        return repository.save(existingOrder);
    }

    public void deleteOrder(Long id) {
        repository.deleteById(id);
    }
}
