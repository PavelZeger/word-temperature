package com.zeger.dto;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

/**
 * @author Pavel Zeger
 */
@Builder
@Value
public class DailyTemp {

    LocalDate date;
    double temperature;
}
