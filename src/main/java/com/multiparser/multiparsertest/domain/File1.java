package com.multiparser.multiparsertest.domain;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by IT180517 on 7/10/2017.
 */
public class File1 {
    private String date;
    private String ref1;
    private String ref2;
    private String project_task;
    private String hours;
    private String days;

    public void setDate(String date) {
        this.date = date;
    }

    public void setRef1(String ref1) {
        this.ref1 = ref1;
    }

    public void setRef2(String ref2) {
        this.ref2 = ref2;
    }

    public void setProject_task(String project_task) {
        this.project_task = project_task;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getDate() {
        return date;
    }

    public String getRef1() {
        return ref1;
    }

    public String getRef2() {
        return ref2;
    }

    public String getProject_task() {
        return project_task;
    }

    public String getHours() {
        return hours;
    }

    public String getDays() {
        return days;
    }
}
