package com.example.pspdemo.service;

import com.example.pspdemo.entity.AlipayOrder;
import com.example.pspdemo.repository.PaymentOrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class PaymentOrderServiceTest {

    @Mock
    PaymentOrderRepository paymentOrderRepository;

    @InjectMocks
    PaymentOrderService paymentOrderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Test Case: 支付宝的交易号为空,创建失败，抛出业务异常“交易号不能为空”
    @Test
    void createOrder_shouldThrowException_whenTransactionIdIsNull() {
        AlipayOrder order = new AlipayOrder();
        order.setAlipayTransactionId(null);

        BusinessException exception = assertThrows(BusinessException.class, () -> paymentOrderService.createOrder(order));
        assertEquals("交易号不能为空", exception.getMessage());
    }

    // Test Case: 支付宝的交易号不为16位数字，创建失败，抛出业务异常“交易号非法”
    @Test
    void createOrder_shouldThrowException_whenTransactionIdIsInvalid() {
        AlipayOrder order = new AlipayOrder();
        order.setAlipayTransactionId("12345");

        BusinessException exception = assertThrows(BusinessException.class, () -> paymentOrderService.createOrder(order));
        assertEquals("交易号非法", exception.getMessage());
    }

    // Test Case: 支付宝的交易号为16位数字，创建成功
    @Test
    void createOrder_shouldSucceed_whenTransactionIdIsValid() throws BusinessException {
        AlipayOrder order = new AlipayOrder();
        order.setAlipayTransactionId("1234567890123456");

        when(paymentOrderRepository.save(order)).thenReturn(order);

        AlipayOrder savedOrder = (AlipayOrder) paymentOrderService.createOrder(order);
        assertEquals("1234567890123456", savedOrder.getAlipayTransactionId());
    }
}
