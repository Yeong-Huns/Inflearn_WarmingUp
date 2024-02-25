package com.myapi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Getter
@NoArgsConstructor
public class FruitMemoryEntity {
    private long id;
    private String name;
    private long price;
    private LocalDate stocked_date;
    private boolean sold_out;

    public FruitMemoryEntity(long id, FruitInfoEntity fruitInfoEntity){
        this.id = id;
        this.name = fruitInfoEntity.getName();
        this.price = fruitInfoEntity.getPrice();
        this.stocked_date = fruitInfoEntity.getStocked_date();
        this.sold_out = fruitInfoEntity.isSold_out();
    }
    public void updateSold_out(){
        this.sold_out = true;
    }
}
