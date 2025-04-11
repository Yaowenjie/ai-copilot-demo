package com.example.pspdemo.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("ALIPAY")
public class AlipayOrder extends PaymentOrder {
    private String alipayTransactionId;
    // ...getters and setters...
}
