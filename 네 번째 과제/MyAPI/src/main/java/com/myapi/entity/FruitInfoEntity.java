package com.myapi.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Getter
@NoArgsConstructor
public class FruitInfoEntity {
    private long id;
    private String name;
    private long price;
    private LocalDate stocked_date;
    private boolean sold_out;
    @Builder
    public FruitInfoEntity(String name, long price, LocalDate stocked_date) {
        this.name = name;
        this.price = price;
        this.stocked_date = stocked_date;
        this.sold_out = false;
    }
}
