package com.accenture.workhour_service.workhour_service.model;

//import com.couchbase.client.core.deps.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.couchbase.client.core.deps.com.fasterxml.jackson.annotation.JsonInclude;
//import com.couchbase.client.core.deps.com.fasterxml.jackson.databind.annotation.JsonDeserialize;
//import com.couchbase.client.core.deps.com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
@JsonDeserialize(builder = Workhour.WorkhourBuilder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document
public class Workhour {
    @Id
    private String empId;
    private int yearMonth;
    private int count;

    public Workhour() {
    }

    public Workhour(WorkhourBuilder workhourBuilder) {
        this.empId= workhourBuilder.empId;
        this.yearMonth=workhourBuilder.yearMonth;
        this.count=workhourBuilder.count;
    }

    public String getEmpId() {
        return empId;
    }

    public int getYearMonth() {
        return yearMonth;
    }

    public int getCount() {
        return count;
    }
    @JsonPOJOBuilder(withPrefix = "set")
    public static class WorkhourBuilder {

        protected String empId;
        protected int yearMonth;
        protected int count;


        public WorkhourBuilder setEmpId(String empId) {
            this.empId = empId;
            return this;
        }

        public WorkhourBuilder setYearMonth(int yearMonth) {
            this.yearMonth = yearMonth;
            return this;
        }

        public WorkhourBuilder setCount(int count) {
            this.count = count;
            return this;
        }


        public Workhour build() {
            return new Workhour(this);
        }
    }
}
