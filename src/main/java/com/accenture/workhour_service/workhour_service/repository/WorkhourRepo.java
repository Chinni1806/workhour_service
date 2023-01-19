package com.accenture.workhour_service.workhour_service.repository;

import com.accenture.workhour_service.workhour_service.model.Workhour;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkhourRepo extends CouchbaseRepository<Workhour,String> {
List<Workhour> findByEmpId(String empId);
}
