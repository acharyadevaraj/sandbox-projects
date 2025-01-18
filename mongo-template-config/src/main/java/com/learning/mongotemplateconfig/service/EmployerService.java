package com.learning.mongotemplateconfig.service;

import com.learning.mongotemplateconfig.dto.EmployerResponse;
import com.learning.mongotemplateconfig.entity.Employer;
import com.mongodb.internal.operation.AggregateOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class EmployerService {

    MongoTemplate mongoTemplate;

    @Autowired
    public EmployerService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<EmployerResponse> getAllEmployers() {
        List<AggregationOperation> operations = Arrays.asList(
                Aggregation.project()
                        .and("id").as("id")
                        .and("email").as("email")
                        .and("companyName").as("companyName")
        );

        Aggregation aggregation = Aggregation.newAggregation(operations);
        List<EmployerResponse> mappedResults = mongoTemplate.aggregate(
                aggregation, Employer.class, EmployerResponse.class).getMappedResults();
        if (mappedResults.isEmpty()) {
            log.error("Not Found");
        }
        return mappedResults;
    }
}
