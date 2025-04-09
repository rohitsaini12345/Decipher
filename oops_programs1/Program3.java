class Student{    
 int id;    
 String name;    
}    
public class Program3{    
 public static void main(String args[]){     
  Student s1=new Student();    
  Student s2=new Student();        
  s1.id=101;    
  s1.name="Rohit";    
  s2.id=102;    
  s2.name="Ajay";       
  System.out.println(s1.id+" "+s1.name);    
  System.out.println(s2.id+" "+s2.name);    
 }    
}    