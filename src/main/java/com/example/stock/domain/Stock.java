package com.example.stock.domain;

import javax.persistence.*;

@Entity
public class Stock {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version;

    private Long productId;

    private Long quantity;

    public Stock() {
    }

    public Stock(Long productId, Long quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void decrease(Long quantity){
        if (this.quantity - quantity < 0){
            throw new RuntimeException("재고는 0개 미만일 수 없습니다.");
        }
        this.quantity -= quantity;
    }
}
