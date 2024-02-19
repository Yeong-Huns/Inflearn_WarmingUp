package com.myapi.dto.request;

import com.myapi.entity.CalcEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CalcRequest {
    private int num1;
    private int num2;

    public CalcEntity toEntity() {
        return CalcEntity.builder()
                .num1(num1)
                .num2(num2)
                .build();
    }
}
