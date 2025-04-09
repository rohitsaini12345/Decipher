class Student {    
    int id;    
    String name;       
    public Student(int id, String name) {    
        this.id = id;    
        this.name = name;    
    }        
    public void displayInformation() {    
        System.out.println("Student ID: " + id);    
        System.out.println("Student Name: " + name);    
    }    
}    
public class Program5 {    
    public static void main(String[] args) {       
        Student student1 = new Student(1, "John Doe");    
        Student student2 = new Student(2, "Jane Smith");       
        student1.displayInformation();    
        student2.displayInformation();    
    }    
}    