package com.aslan.mongoaggregation.repository;

        import com.aslan.mongoaggregation.model.Consumption;
        import org.springframework.data.mongodb.repository.MongoRepository;
        import org.springframework.data.repository.CrudRepository;

/**
 * Created by aslan.atasoy on 01/28/2018.
 */
public interface ConsumptionRepository extends MongoRepository<Consumption,String>{
}
