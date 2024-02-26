package com.myapi.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@Entity
@Getter
@NoArgsConstructor
public class CalcEntity {
    private int num1;
    private int num2;

    @Builder
    public CalcEntity(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

}
