package com.aslan.mongoaggregation.enums;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by aslan.atasoy on 01/28/2018.
 */
@Document
@Getter
public enum Profile {
    NIGHT("N"),
    DAY("D");
    private String profile;

    public String profile(){
        return profile;
    }

    Profile(String profile){
        this.profile = profile;
    }
}
