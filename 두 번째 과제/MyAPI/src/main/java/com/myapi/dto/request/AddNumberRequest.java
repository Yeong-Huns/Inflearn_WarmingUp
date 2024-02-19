package com.myapi.dto.request;

import lombok.Getter;

import java.util.List;

@Getter
public class AddNumberRequest {
    private List<Integer> numbers;
}
