package com.accenture.workhour_service.workhour_service.repository;

import com.accenture.workhour_service.workhour_service.model.Workhour;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkhourRepo extends CouchbaseRepository<Workhour,String> {
    //@Query("#{#n1q1.selectEntity} WHERE #{#n1q1.filter} AND")
    //String query="SELECT count FROM Workhour where this.empId=empId And this.yearMonth=yearMonth ";
    @Query("#{#n1q1.SELECTEntity} USE KEYS [$empId,$yearMonth]")
    Number findByIdAndYearMonth(@Param("empId") String empId,@Param("yearMonth") Number yearMonth);
}
