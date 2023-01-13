package com.accenture.workhour_service.workhour_service.repository;

import com.accenture.workhour_service.workhour_service.model.Workhour;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkhourRepo extends CouchbaseRepository<Workhour,String> {

}
