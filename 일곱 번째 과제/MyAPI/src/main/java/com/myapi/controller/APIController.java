package com.myapi.controller;

import com.myapi.dto.calc.request.AddNumberRequest;
import com.myapi.dto.calc.request.CalcRequest;
import com.myapi.dto.calc.response.CalcResponse;
import com.myapi.dto.calc.response.DayOfWeekResponse;
import com.myapi.dto.fruit.request.FruitInfoRequest;
import com.myapi.dto.fruit.request.SoldFruitInfoRequest;
import com.myapi.dto.fruit.response.GetFruitInfoListResponse;
import com.myapi.dto.fruit.response.GetSoldFruitCountResponse;
import com.myapi.dto.fruit.response.SalesAmountResponse;
import com.myapi.entity.CalcEntity;
import com.myapi.service.APIServiceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class APIController {

    private final APIServiceV2 apiService;

    @GetMapping("/api/v1/calc")
    public ResponseEntity<CalcResponse> calcResponse(@RequestParam int num1, @RequestParam int num2) {
        CalcEntity calcEntity = apiService.calculatorService(new CalcRequest(num1, num2));
        CalcResponse calcResponse = new CalcResponse(calcEntity);
        return ResponseEntity.ok()
                .body(calcResponse);
    }

    @GetMapping("/api/day-of-the-week")
    public ResponseEntity<DayOfWeekResponse> dateResponse(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate localDate) {
        DayOfWeek dayOfWeek = apiService.dayOfWeekService(localDate);
        DayOfWeekResponse dayOfWeekResponse = new DayOfWeekResponse(dayOfWeek);
        return ResponseEntity.ok()
                .body(dayOfWeekResponse);
    }

    @PostMapping("/api/v1/addNumbers")
    public ResponseEntity<Integer> addNumber(@RequestBody AddNumberRequest addNumberRequest) {
        Integer sum = apiService.addNumber(addNumberRequest);
        return ResponseEntity.status(HttpStatus.CREATED) // 201 테스트
                .body(sum);
    }
    @PostMapping("/api/v1/fruit")
    public ResponseEntity<Void> saveFruitInfo (@RequestBody FruitInfoRequest fruitInfoRequest ){
        apiService.saveFruitInfo(fruitInfoRequest);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/api/v1/fruit")
    public void soldFruitInfo(@RequestBody SoldFruitInfoRequest soldFruitInfoRequest){
        apiService.soldFruitInfo(soldFruitInfoRequest);
    }

    @GetMapping("/api/v1/fruit/stat")
    public ResponseEntity<SalesAmountResponse> salesAmount(@RequestParam String name){
        SalesAmountResponse salesAmountRequest = apiService.salesAmount(name);
        return ResponseEntity.ok()
                .body(salesAmountRequest);
    }

    @GetMapping("/api/v1/fruit/count")
    public ResponseEntity<GetSoldFruitCountResponse> getSoldFruitCount (@RequestParam String name){
        GetSoldFruitCountResponse getSoldFruitCountResponse = apiService.getSoldFruitCount(name);
        return ResponseEntity.ok()
                .body(getSoldFruitCountResponse);
    }

    @GetMapping("/api/v1/fruit/list")
    public ResponseEntity<List<GetFruitInfoListResponse>> getFruitInfoList(@RequestParam String option, @RequestParam long price){
        List<GetFruitInfoListResponse> getFruitInfoListResponseList = apiService.getFruitInfoList(option, price);
        return ResponseEntity.ok()
                .body(getFruitInfoListResponseList);
    }
}
