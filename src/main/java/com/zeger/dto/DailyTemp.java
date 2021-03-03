package com.zeger.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

/**
 * @author Pavel Zeger
 */
@Builder
@AllArgsConstructor
@Getter
public class DailyTemp {

    private LocalDate date;
    private double temperature;
}
