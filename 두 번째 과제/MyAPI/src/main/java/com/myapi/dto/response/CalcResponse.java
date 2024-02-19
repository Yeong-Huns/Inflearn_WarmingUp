package com.myapi.dto.response;

import com.myapi.entity.CalcEntity;
import lombok.Getter;

@Getter
public class CalcResponse {
    private final int add;
    private final int minus;
    private final int multiply;

    public CalcResponse(CalcEntity calcEntity) {
        this.add = calcEntity.getNum1() + calcEntity.getNum2();
        this.minus = calcEntity.getNum1() - calcEntity.getNum2();
        this.multiply = calcEntity.getNum1() * calcEntity.getNum2();
    }
}
