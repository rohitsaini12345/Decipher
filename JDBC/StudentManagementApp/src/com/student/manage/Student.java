package com.student.manage;

public class Student {
    private int student_Id;
    private  String student_Name;
    private String student_Phoneno;
    private String student_City;

    public int getStudent_Id(){
        return student_Id;
    }
    public void setStudent_Id(int student_Id){
        this.student_Id=student_Id;
    }
    public String getStudent_Name(){
        return student_Name;
    }
    public void setStudent_Name(String student_Name){
        this.student_Name=student_Name;
    }
    public String getStudent_Phoneno(){
        return student_Phoneno;
    }
    public void setStudent_Phoneno(String student_Phoneno){
        this.student_Phoneno=student_Phoneno;
    }
    public String getStudent_City(){
        return student_City;
    }
    public void setStudent_City(String student_City){
        this.student_City=student_City;
    }


    public Student(int student_Id,String student_Name, String student_Phoneno, String student_City){
        super();
        this.student_Id=student_Id;
        this.student_Name=student_Name;
        this.student_Phoneno=student_Phoneno;
        this.student_City=student_City;
    }
    public Student(String student_Name, String student_Phoneno, String student_City){
        super();
        this.student_Name=student_Name;
        this.student_Phoneno=student_Phoneno;
        this.student_City=student_City;
    }
    public Student(){
        super();
    }
    @Override
    public String toString(){
        return "Student[student_Id="+ student_Id +",student_Name="+ student_Name+""+
                ",student_Phoneno="+ student_Phoneno+",student_City="+ student_City+"]";
    }



}
