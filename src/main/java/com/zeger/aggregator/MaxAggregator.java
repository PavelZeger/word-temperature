package com.zeger.aggregator;

import com.zeger.dto.City;
import com.zeger.dto.DailyTemp;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Pavel Zeger
 */
@RequiredArgsConstructor
public class MaxAggregator extends Aggregator {

    private final List<String> ids;

    @Override
    public List<String> aggregate() {
        Set<City> cities = getCities(ids);
        Map<String, List<DailyTemp>> cityByTemp = getCityByTemp(cities);
        Map<String, Double> cityByMaxTemp = getCityByMaxTemp(cityByTemp);
        return getTopCities(cityByMaxTemp);
    }

    private Map<String, Double> getCityByMaxTemp(Map<String, List<DailyTemp>> cityByTemp) {
        return cityByTemp.entrySet().parallelStream()
                .collect(Collectors.toUnmodifiableMap(Map.Entry::getKey, entry -> getMax(entry.getValue())));
    }

    private double getMax(List<DailyTemp> dailyTemps) {
        return dailyTemps.stream()
                .mapToDouble(DailyTemp::getTemperature)
                .summaryStatistics()
                .getMax();
    }

}
