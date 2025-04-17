import com.student.manage.Student;
import com.student.manage.StudentDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Student Management App");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("press 1 to Add Student");
            System.out.println("Press 2 to Delete Student");
            System.out.println("Press 3 to Display Student");
            System.out.println("Press 4 to Exit App");

            int c = Integer.parseInt(br.readLine());

            if (c == 1) {
                //add student

                System.out.println("Enter Id: ");
                int id=  Integer.parseInt(br.readLine());

                System.out.println("Enter name: ");
                String name= br.readLine();

                System.out.println("Enter phoneno: ");
                String phoneno= br.readLine();

                System.out.println("Enter City: ");
                String city= br.readLine();

                Student st=new Student(id,name,phoneno,city);
                boolean answer=StudentDao.insertStudentToDB(st);

                if(answer){
                    System.out.println("Successfully added");
                }
                else{
                    System.out.println("Something went wrong");
                }

                System.out.println(st);
            } else if (c == 2) {
                // delete student
                System.out.println("Enter student id to delete: ");
                int userId=Integer.parseInt(br.readLine());
                boolean f=StudentDao.deleteStudent(userId);

                if(f){
                    System.out.println("Successfully deleted");
                }
                else{
                    System.out.println("Something went wrong");
                }
            } else if (c == 3) {
                // display student
                System.out.println("Display Students");
                StudentDao.showAllStudents();
            } else if (c == 4) {
                //exit app
                break;
            }
            else{

            }
        }
        System.out.println("Thank u for using my app");
    }
}