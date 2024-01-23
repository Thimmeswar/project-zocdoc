package com.doctor.Respository;

import com.doctor.Entity.Reviews;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewRepository extends MongoRepository<Reviews,Long> {
    List<Reviews> findByDoctorId(long doctorId);


}
