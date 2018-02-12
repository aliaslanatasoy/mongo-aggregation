package com.aslan.mongoaggregation.dto;

import com.aslan.mongoaggregation.enums.Profile;
import lombok.Data;

import java.io.Serializable;
import java.time.Month;

/**
 * Created by aslan.atasoy on 01/28/2018.
 */
@Data
public class ConsumptionDTO implements Serializable{
    private String id;
    private Month month;
    private Float consumption;
    private Profile profile;
}
