package com.myapi.service;

import com.myapi.dto.calc.request.AddNumberRequest;
import com.myapi.dto.calc.request.CalcRequest;
import com.myapi.dto.fruit.request.FruitInfoRequest;
import com.myapi.dto.fruit.request.SoldFruitInfoRequest;
import com.myapi.dto.fruit.response.GetFruitInfoListResponse;
import com.myapi.dto.fruit.response.GetSoldFruitCountResponse;
import com.myapi.dto.fruit.response.SalesAmountResponse;
import com.myapi.entity.CalcEntity;
import com.myapi.entity.FruitInfoEntity;
import com.myapi.entity.FruitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class APIServiceV2 {
    private final FruitRepository repository;
    public CalcEntity calculatorService(CalcRequest request) {
        return request.toEntity();
    }

    public DayOfWeek dayOfWeekService(LocalDate localDate) {
        return localDate.getDayOfWeek();
    }

    public Integer addNumber(AddNumberRequest addNumberRequest) {
        return addNumberRequest.getNumbers().stream().reduce(0, Integer::sum);
    }
    @Transactional
    public void saveFruitInfo(FruitInfoRequest request){
        repository.save(request.toEntity());
    }
    @Transactional
    public void soldFruitInfo(SoldFruitInfoRequest request){
        FruitInfoEntity fruitInfo = repository.findByIdAndSoldOutFalse(request.getId())
                .orElseThrow(IllegalArgumentException::new);
        fruitInfo.update_Sold_out();
    }
    @Transactional
    public SalesAmountResponse salesAmount(String name){
        List<FruitInfoEntity> fruitInfoEntityList = repository.findAllByName(name);
        if(fruitInfoEntityList.isEmpty()) throw new IllegalArgumentException("해당이름의 과일은 존재하지 않습니다.");
        long salesAmount = 0;
        long notSalesAmount = 0;
        for(FruitInfoEntity fruitInfo : fruitInfoEntityList) {
            if (fruitInfo.isSoldOut()) salesAmount += fruitInfo.getPrice();
            else notSalesAmount += fruitInfo.getPrice();
        }
        return new SalesAmountResponse(salesAmount, notSalesAmount);
    }
    @Transactional
    public GetSoldFruitCountResponse getSoldFruitCount(String name){
        return new GetSoldFruitCountResponse(repository.countBySoldOutTrueAndName(name));
    }
    @Transactional
    public List<GetFruitInfoListResponse> getFruitInfoList(String option, long price){
        if(!option.equals("GTE") && !option.equals("LTE")) throw new IllegalArgumentException();
        if(option.equals("GTE")) return repository.findAllByPriceGreaterThanEqual(price).stream().map(GetFruitInfoListResponse::new).toList();
        return repository.findAllByPriceLessThanEqual(price).stream().map(GetFruitInfoListResponse::new).toList();
    }
}
