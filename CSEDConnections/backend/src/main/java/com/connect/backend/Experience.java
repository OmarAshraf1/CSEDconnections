package com.connect.backend;

public class Experience {
    String companyName;
    String location;
    String startDate, endDate;
    boolean current;
    String position;

    public Experience(String companyName, String location, String startDate, String endDate, String position) {
        this.companyName = companyName;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.position = position;
    }

    public Experience(String name, String loc, String pos) {
        companyName = name;
        location = loc;
        position = pos;
    }

}
