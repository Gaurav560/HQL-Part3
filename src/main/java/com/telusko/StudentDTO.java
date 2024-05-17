package com.telusko;

public class StudentDTO {
    private int marks;
    private String sname;
    // Constructor with parameters
    public StudentDTO(String sname, int marks) {
        this.marks = marks;
        this.sname = sname;
    }

    // Getters and setters
    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
