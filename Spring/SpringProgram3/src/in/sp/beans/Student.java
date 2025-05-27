package in.sp.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
    
	@Value("Rohit")
    private String name;
	@Value("101")
    private int rollno;
	@Value("90")
    private Float marks;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRollno() {
        return rollno;
    }
    public void setRollno(int rollno) {
        this.rollno = rollno;
    }
    public Float getMarks() {
        return marks;
    }
    public void setMarks(Float marks) {
        this.marks = marks;
    }
    public void display() {
    	System.out.println("Name: "+name);
    	System.out.println("Rollno: "+rollno);
    	System.out.println("Marks: "+marks);
    }
    }
