package com.connect.backend.Controllers;

public class Experience {
    public String companyName;
    public String location;
    public String startDate, endDate;
    public boolean current;
    public String position;


    public String toString(){
        return companyName +" "+location+" "+position;
    }
    
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
