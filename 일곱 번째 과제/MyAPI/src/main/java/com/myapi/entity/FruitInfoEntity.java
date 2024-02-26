package com.myapi.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Getter
@Entity
@Table(name = "fruit")
@NoArgsConstructor
public class FruitInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 20)
    private String name;
    @Column(name= "price")
    private long price;
    @Column(name = "stocked_date")
    private LocalDate stockedDate;
    @Column(name = "sold_out")
    private boolean soldOut;
    @Builder
    public FruitInfoEntity(String name, long price, LocalDate stockedDate) {
        this.name = name;
        this.price = price;
        this.stockedDate = stockedDate;
        this.soldOut = false;
    }
    public void update_Sold_out(){
        this.soldOut = true;
    }
}
