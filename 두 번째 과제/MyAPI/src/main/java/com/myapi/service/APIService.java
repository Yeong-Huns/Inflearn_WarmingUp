package com.myapi.service;

import com.myapi.dto.request.AddNumberRequest;
import com.myapi.dto.request.CalcRequest;
import com.myapi.entity.CalcEntity;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Service
public class APIService {
    public CalcEntity calculatorService(CalcRequest request) {
        return request.toEntity();
    }

    public DayOfWeek dayOfWeekService(LocalDate localDate) {
        return localDate.getDayOfWeek();
    }

    public int addNumber(AddNumberRequest addNumberRequest) {
        return addNumberRequest.getNumbers().stream().mapToInt(Integer::intValue).sum();
    }
}
