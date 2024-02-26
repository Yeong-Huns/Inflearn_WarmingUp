package com.myapi.repository;

import com.myapi.dto.fruit.request.SoldFruitInfoRequest;
import com.myapi.dto.fruit.response.SalesAmountResponse;
import com.myapi.entity.FruitInfoEntity;
import com.myapi.entity.FruitMemoryEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Primary
@Repository
public class FruitMemoryJDBCRepository implements FruitJDBCRepository {

    List<FruitMemoryEntity> memoryEntities = new ArrayList<>();
    private long id = 1;
    public FruitMemoryEntity toMemoryEntity(FruitInfoEntity fruitInfoEntity){
        return new FruitMemoryEntity(this.id, fruitInfoEntity);
    }

    @Override
    public void saveFruitInfo(FruitInfoEntity fruitInfoEntity){
        memoryEntities.add(toMemoryEntity(fruitInfoEntity));
        this.id++;
    }
    @Override
    public void soldFruitInfo(SoldFruitInfoRequest soldFruitInfoRequest){ //없는 ID값에 접근하려하면 IllegalArgumentException
        List<FruitMemoryEntity> FruitInfoEntity =  memoryEntities.stream()
                .filter(fruitMemoryEntity-> fruitMemoryEntity.getId() == soldFruitInfoRequest.getId()&&!fruitMemoryEntity.isSold_out())
                .toList();
        if(FruitInfoEntity.isEmpty()) throw new IllegalArgumentException();
        FruitInfoEntity.get(0).updateSold_out();
    }
    @Override
    public SalesAmountResponse salesAmount(String name){
        List<FruitMemoryEntity> FruitInfoEntity =  memoryEntities.stream()
                .filter(fruitMemoryEntity-> fruitMemoryEntity.getName().equals(name))
                .toList();
        if(FruitInfoEntity.isEmpty()) throw new IllegalArgumentException("존재하지 않는 과일입니다.");

        long sales = 0;
        long notsales = 0;
        for(FruitMemoryEntity FruitEntity : FruitInfoEntity){
            System.out.println("ID : " + FruitEntity.getId() + "\t Name : " + FruitEntity.getName() + "\t Price : " + FruitEntity.getPrice() + "\t stocked_date : " + FruitEntity.getStocked_date() + "\t sold_out : " + FruitEntity.isSold_out());
            if(FruitEntity.isSold_out()) sales += FruitEntity.getPrice();
            else notsales += FruitEntity.getPrice();
        }
        return new SalesAmountResponse(sales, notsales);
    }
}
