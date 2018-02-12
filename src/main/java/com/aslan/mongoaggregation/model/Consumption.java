package com.aslan.mongoaggregation.model;

import com.aslan.mongoaggregation.enums.Profile;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;

import javax.persistence.*;
import javax.sound.midi.Sequence;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Month;

/**
 * Created by aslan.atasoy on 01/28/2018.
 */
@Document(collection = "consumption")
@Data
public class Consumption implements Serializable{

    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    private Month month;

    private Float consumption;

    @Enumerated
    private Profile profile;

}
