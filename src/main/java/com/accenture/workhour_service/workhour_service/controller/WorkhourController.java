package com.accenture.workhour_service.workhour_service.controller;

import com.accenture.workhour_service.workhour_service.model.WorkHourReq;
import com.accenture.workhour_service.workhour_service.model.Workhour;
import com.accenture.workhour_service.workhour_service.service.WorkhourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/Workhour")
public class WorkhourController {
    @Autowired
    WorkhourService workhourService;
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void setWorkhour(@RequestBody Workhour workhour){
        this.workhourService.setWorkhour(workhour);
    }
    @GetMapping("/{empId}")
    @ResponseStatus(HttpStatus.OK)
    public Number getEmpCountById(@PathVariable("empId") String empId){
        return this.workhourService.getEmpCountById(empId);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Workhour> getAllEmployeesLeave() {
        return this.workhourService.getAllEmployeesLeave();
    }
    @PostMapping("/req")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<Workhour> getEmployeeLeaveByEmpIdAndYearMonth(@RequestBody WorkHourReq workhourreq){
        return this.workhourService.getEmployeeLeaveByEmpIdAndYearMonth(workhourreq);
    }

}
