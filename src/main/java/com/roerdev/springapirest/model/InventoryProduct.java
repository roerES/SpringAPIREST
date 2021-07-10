package com.roerdev.springapirest.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@ToString
@Data
@EqualsAndHashCode
@Component
public class InventoryProduct implements Serializable {

    private Long amount;
    @Autowired
    private Product product;

    public InventoryProduct() {
    }

    public InventoryProduct(Long amount, Product product) {
        this.amount = amount;
        this.product = product;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
