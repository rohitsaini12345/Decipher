public class Immutable {
    private final String student;
    Immutable(String student){
        this.student=student;
    }
    public String getStudent(){
        return student;
    }
    public static void main(String[] args){
        Immutable immut=new Immutable("abcd");
        System.out.println(immut.getStudent());
    }
}
