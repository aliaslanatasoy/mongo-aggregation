package com.aslan.mongoaggregation.service;

import com.aslan.mongoaggregation.dto.AverageResultDTO;
import com.aslan.mongoaggregation.dto.ConsumptionDTO;
import com.aslan.mongoaggregation.enums.Profile;
import com.aslan.mongoaggregation.exception.consumption.ConsumptionNotFoundException;
import com.aslan.mongoaggregation.model.Consumption;
import com.aslan.mongoaggregation.repository.ConsumptionRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * Created by aslan.atasoy on 01/28/2018.
 */
@Service
public class ConsumptionService {
    @Autowired
    private ConsumptionRepository consumptionRepository;

    @Autowired
    private DozerBeanMapper mapper;

    @Autowired
    private MongoTemplate mongoTemplate;

    public ConsumptionDTO findConsumption(String id){
        return mapper.map(consumptionRepository.findOne(id),ConsumptionDTO.class);
    }

    @Transactional
    public ConsumptionDTO addConsumption(ConsumptionDTO consumptionDTO) {
        Consumption consumption = mapper.map(consumptionDTO,Consumption.class);
        ConsumptionDTO tempConsumptionDTO= mapper.map(consumptionRepository.save(consumption),ConsumptionDTO.class);
        return tempConsumptionDTO;
    }

    @Transactional
    public void deleteConsumption(String id) throws Exception{
        Consumption consumption = consumptionRepository.findOne(id);
        if(consumption == null){
            throw new ConsumptionNotFoundException("Consumption not found");
        }
        consumptionRepository.delete(id);

    }

    @Transactional
    public List<AverageResultDTO> averageFractionByMonth(String month){
        GroupOperation groupOperation = group("month").avg("consumption").as("avgConsumption");
        Criteria criteria = where("month").is(month);

        Aggregation aggregation = newAggregation(match(criteria),groupOperation);
        AggregationResults<AverageResultDTO> aggregationResults = mongoTemplate.aggregate(aggregation,Consumption.class,AverageResultDTO.class);
        System.out.println("aslan");
        return aggregationResults.getMappedResults();
    }


    public List<ConsumptionDTO> finAllConsumptions() {
        List<ConsumptionDTO> consumptionDTOS = new ArrayList<>();
        List<Consumption> retrievedConsumptions = consumptionRepository.findAll();
        retrievedConsumptions.forEach(consumption -> consumptionDTOS.add(mapper.map(consumption,ConsumptionDTO.class)));
        return consumptionDTOS;
    }
}
