package com.myapi.dto.response;

import lombok.Getter;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

@Getter
public class DayOfWeekResponse {
    private final String dayOfTheWeek;

    public DayOfWeekResponse(DayOfWeek dayOfTheWeek) { //DayOfWeek -> String
        this.dayOfTheWeek = dayOfTheWeek.getDisplayName(TextStyle.SHORT, Locale.US).toUpperCase(); //예시 대문자 잊지말자
    }
}
