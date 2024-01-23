package com.doctor.Respository;
import com.doctor.Entity.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DoctorRepository extends MongoRepository<Doctor,Long> {

    List<Doctor> findByNameIgnoreCaseContainingOrSpecializationIgnoreCaseContaining(String name, String specialization);
}
