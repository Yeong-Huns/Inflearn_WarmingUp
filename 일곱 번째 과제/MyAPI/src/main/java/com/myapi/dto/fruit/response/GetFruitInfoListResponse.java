package com.myapi.dto.fruit.response;

import com.myapi.entity.FruitInfoEntity;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class GetFruitInfoListResponse {
    private final String name;
    private final long price;
    private final LocalDate warehousingDate;

    public GetFruitInfoListResponse(FruitInfoEntity fruitInfoEntity) {
        this.name = fruitInfoEntity.getName();
        this.price = fruitInfoEntity.getPrice();
        this.warehousingDate = fruitInfoEntity.getStockedDate();
    }
}
