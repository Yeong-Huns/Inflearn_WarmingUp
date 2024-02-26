package com.myapi.service;

import com.myapi.dto.calc.request.AddNumberRequest;
import com.myapi.dto.calc.request.CalcRequest;
import com.myapi.dto.fruit.request.FruitInfoRequest;
import com.myapi.dto.fruit.request.SoldFruitInfoRequest;
import com.myapi.dto.fruit.response.SalesAmountResponse;
import com.myapi.entity.CalcEntity;
import com.myapi.repository.FruitJDBCRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class APIService {
    private final FruitJDBCRepository fruitJDBCRepository;

    public CalcEntity calculatorService(CalcRequest request) {
        return request.toEntity();
    }

    public DayOfWeek dayOfWeekService(LocalDate localDate) {
        return localDate.getDayOfWeek();
    }

    public Integer addNumber(AddNumberRequest addNumberRequest) {
        return addNumberRequest.getNumbers().stream().reduce(0, Integer::sum);
    }

    public void saveFruitInfo(FruitInfoRequest request) {
        fruitJDBCRepository.saveFruitInfo(request.toEntity());
    }

    public void soldFruitInfo(SoldFruitInfoRequest request) {
        fruitJDBCRepository.soldFruitInfo(request);
    }

    public SalesAmountResponse salesAmount(String name) {
        return fruitJDBCRepository.salesAmount(name);
    }
}
