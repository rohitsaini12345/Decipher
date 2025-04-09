
public class CollegeStudent {
    private int studentId;
    private String name;
    private double marks;

    public CollegeStudent(int studentId, String name, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.marks = marks;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        if (marks >= 0 && marks <= 100) {
            this.marks = marks;
        }
    }

    public static void main(String[] args) {
        CollegeStudent s1 = new CollegeStudent(101, "Rohit", 88.5);

        System.out.println("ID: " + s1.getStudentId());
        System.out.println("Name: " + s1.getName());
        System.out.println("Marks: " + s1.getMarks());

    }
}
