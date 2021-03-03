package com.zeger.service;

import com.zeger.dto.AggregateType;

import java.util.List;

/**
 * @author Pavel Zeger
 */
public class TopCityService {

    public List<String> getTopCities (List<String> cityIds, String aggregationType) {
        AggregateType aggregateType = AggregateType.valueOf(aggregationType.toUpperCase());
        return aggregateType.execute(cityIds);
    }

}
