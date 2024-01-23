package com.doctor.Service;

import com.doctor.Entity.Reviews;
import com.doctor.Playload.MahiDto;
import com.doctor.Playload.Reviewdto;

import java.util.List;

public interface ReviewService {


    List<Reviewdto> getfindByDoctorId(long id);

    Reviewdto saveTheReviews(Reviewdto dto);

    MahiDto GetallReviews(long doctorId);
}
