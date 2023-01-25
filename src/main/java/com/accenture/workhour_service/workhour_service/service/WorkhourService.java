package com.accenture.workhour_service.workhour_service.service;

import com.accenture.workhour_service.workhour_service.model.WorkHourReq;
import com.accenture.workhour_service.workhour_service.model.Workhour;
import com.accenture.workhour_service.workhour_service.repository.WorkhourRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
    public WorkHourReq getEmployeeLeaveByEmpIdAndYearMonth(@PathVariable String empId, @PathVariable int yearMonth){
        int count=getEmpLeaveCount(empId);

        int noOfDays=FindNoOfDays(yearMonth);
        return new WorkHourReq
                .WorkHourReqBuilder()
                .setCount(count)
                .setDays(noOfDays)
                .build();
    }

    private int getEmpLeaveCount(String empId) {
        return workhourRepo.findById(empId).orElseThrow().getCount();
    }

    private int FindNoOfDays(int yearMonth){

        int year = Integer.parseInt(("" + yearMonth).substring(0, 4));
        int month = yearMonth % 100;
        if (month == 2) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
                return 29;
            return 28;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11)
            return 30;
        return 31;
    }
}
