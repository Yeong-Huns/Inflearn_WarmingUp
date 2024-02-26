package com.myapi.dto.fruit.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.myapi.entity.FruitInfoEntity;
import lombok.Getter;

import java.time.LocalDate;
@Getter
public class FruitInfoRequest {
    private String name;
    private LocalDate warehousingDate;
    private long price;

    public FruitInfoEntity toEntity(){
        return FruitInfoEntity.builder()
                .name(name)
                .stockedDate(warehousingDate)
                .price(price)
                .build();
    }
}
