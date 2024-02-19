package com.myapi.controller;

import com.myapi.dto.request.AddNumberRequest;
import com.myapi.dto.request.CalcRequest;
import com.myapi.dto.response.CalcResponse;
import com.myapi.dto.response.DayOfWeekResponse;
import com.myapi.entity.CalcEntity;
import com.myapi.service.APIService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;

@RequiredArgsConstructor
@RestController
public class APIController {

    private final APIService apiService;

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
}
