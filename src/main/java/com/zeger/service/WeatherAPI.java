package com.zeger.service;

import com.zeger.dto.City;
import com.zeger.dto.DailyTemp;

import java.util.List;
import java.util.Set;

/**
 * @author Pavel Zeger
 */
public interface WeatherAPI {

    Set<City> getAllCitiesByIds(Set<String> ids);

    List<DailyTemp> getLastYearTemperature(String cityId);

}
