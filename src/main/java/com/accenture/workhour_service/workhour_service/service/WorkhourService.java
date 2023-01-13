package com.accenture.workhour_service.workhour_service.service;

import com.accenture.workhour_service.workhour_service.model.Workhour;
import com.accenture.workhour_service.workhour_service.repository.WorkhourRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class WorkhourService {
    @Autowired
    WorkhourRepo workhourRepo;
    public Workhour insert(Workhour workhour) {
        return workhourRepo.save(workhour);
    }

    public Optional<Workhour> getEmpDataById(String empId) {
        return workhourRepo.findById(empId);
    }

    public List<Workhour> EmpWorkHour() {
        return workhourRepo.findAll();
    }
}
