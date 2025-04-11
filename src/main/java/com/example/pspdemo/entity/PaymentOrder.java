package com.example.pspdemo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "payment_type", discriminatorType = DiscriminatorType.STRING)
public abstract class PaymentOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderNumber;

    private Double amount;

    // ...getters and setters...
}

@Entity
@DiscriminatorValue("ALIPAY")
class AlipayOrder extends PaymentOrder {
    private String alipayTransactionId;
    // ...getters and setters...
}

@Entity
@DiscriminatorValue("WECHAT")
class WeChatOrder extends PaymentOrder {
    private String weChatTransactionId;
    // ...getters and setters...
}

@Entity
@DiscriminatorValue("STRIPE")
class StripeOrder extends PaymentOrder {
    private String cardNumber;
    private LocalDate expiryDate;
    private String cvc;
    // ...getters and setters...
}
