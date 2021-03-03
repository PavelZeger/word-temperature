package com.zeger.dto;

import lombok.Builder;
import lombok.Value;

/**
 * @author Pavel Zeger
 */
@Builder
@Value
public class City {

    String id;
    String name;
    int population;

}
