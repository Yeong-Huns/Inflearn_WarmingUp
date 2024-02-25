package com.myapi.dto.calc.request;

import lombok.Getter;

import java.util.List;

@Getter
public class AddNumberRequest {
    private List<Integer> numbers;
}
