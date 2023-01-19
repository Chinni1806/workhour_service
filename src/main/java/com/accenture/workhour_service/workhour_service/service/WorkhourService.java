package com.accenture.workhour_service.workhour_service.service;

import com.accenture.workhour_service.workhour_service.model.WorkHourReq;
import com.accenture.workhour_service.workhour_service.model.Workhour;
import com.accenture.workhour_service.workhour_service.repository.WorkhourRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
public class WorkhourService {
    @Autowired
    WorkhourRepo workhourRepo;
    public void setWorkhour(Workhour workhour) {
         workhourRepo.save(workhour);
    }

    public Number getEmpCountById(String empId) {
        return workhourRepo.findById(empId).orElseThrow().getCount();
    }

    public List<Workhour> getAllEmployeesLeave() {
        return workhourRepo.findAll();
    }
    public Optional<Workhour> getEmployeeLeaveByEmpIdAndYearMonth(WorkHourReq workhourreq){
        Optional<Workhour> res=workhourRepo.findByEmpId(workhourreq.getEmployeeId()).stream().filter(EmpLeave -> Objects.equals(EmpLeave.getYearMonth().intValue(),
                workhourreq.getYearMonth().intValue())).findFirst();
        return res;
    }
}
