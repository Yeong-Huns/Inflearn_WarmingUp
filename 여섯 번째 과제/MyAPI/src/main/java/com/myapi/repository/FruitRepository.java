package com.myapi.repository;

import com.myapi.dto.fruit.request.SoldFruitInfoRequest;
import com.myapi.dto.fruit.response.SalesAmountResponse;
import com.myapi.entity.FruitInfoEntity;


public interface FruitRepository {
    void saveFruitInfo(FruitInfoEntity fruitInfoEntity);

    void soldFruitInfo(SoldFruitInfoRequest soldFruitInfoRequest);

    SalesAmountResponse salesAmount(String name);
}
