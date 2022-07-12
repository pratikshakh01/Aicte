package com.example.aicte;

public class Student {
    private String Name ;
    private String Usn ;

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }

    private String Branch ;
    private String Remarks;
    private String Points;

    public String getPoints() {
        return Points;
    }

    public void setPoints(String points) {
        Points = points;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUsn() {
        return Usn;
    }

    public void setUsn(String usn) {
        Usn = usn;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }

    /*public String getSec() {
        return Sec;
    }

    public void setSec(String sec) {
        Sec = sec;
    }*/

    public Student ()
    {

    }
    public Student(String name, String usn, String branch, String points, String remarks) {
        Name = name;
        Usn = usn;
        Branch = branch;
        Remarks = remarks;
        Points = points;
    }
}
