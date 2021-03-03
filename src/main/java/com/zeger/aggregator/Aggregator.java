package com.zeger.aggregator;

import com.zeger.dto.City;
import com.zeger.dto.DailyTemp;
import com.zeger.service.CityService;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Pavel Zeger
 */
public abstract class Aggregator {

    int POPULATION_THRESHOLD = 50000;
    CityService cityService = new CityService();

    public Set<City> getCities(List<String> ids) {
        return cityService.getAllCitiesByIds(ids.stream().collect(Collectors.toUnmodifiableSet()));
    }

    public Map<String, List<DailyTemp>> getCityByTemp(Set<City> cities) {
        return cities
                .parallelStream()
                .filter(city -> city.getPopulation() >= POPULATION_THRESHOLD)
                .map(City::getId)
                .collect(Collectors.toUnmodifiableMap(id -> id, cityService::getLastYearTemperature));
    }

    public abstract List<String> aggregate();

}
