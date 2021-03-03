package com.zeger.service;

import com.zeger.dto.City;
import com.zeger.dto.DailyTemp;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Pavel Zeger
 */
public class CityService implements WeatherAPI {

    @Override
    public Set<City> getAllCitiesByIds(Set<String> ids) {
        Set<City> cities = Set.of(
            City.builder().id("1").name("Tel-Aviv").population(300000).build(),
            City.builder().id("2").name("Rehovot").population(49999).build(),
            City.builder().id("3").name("Jerusalem").population(350000).build(),
            City.builder().id("4").name("Haifa").population(150000).build());
        return cities.stream().filter(city -> ids.contains(city.getId())).collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public List<DailyTemp> getLastYearTemperature(String cityId) {
        /* Some unknown logic here */
        return List.of(
                DailyTemp.builder().date(LocalDate.of(2018, 2, 28)).temperature(31.25).build(),
                DailyTemp.builder().date(LocalDate.of(2019, 3, 10)).temperature(25.43).build(),
                DailyTemp.builder().date(LocalDate.of(2020, 7, 1)).temperature(18.09).build(),
                DailyTemp.builder().date(LocalDate.of(2017, 9, 12)).temperature(10.87).build(),
                DailyTemp.builder().date(LocalDate.of(2016, 12, 31)).temperature(45.16).build()
        );
    }

}
