package com.accenture.workhour_service.workhour_service.controller;

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
    public Workhour createWorkhour(@RequestBody Workhour workhour){
        return workhourService.insert(workhour);
    }
    @GetMapping("/{empId}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Workhour> getEmpDataById(@PathVariable("empId") String empId){
        return workhourService.getEmpDataById(empId);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Workhour> EmpWorkHour() {
        return workhourService.EmpWorkHour();
    }

}
