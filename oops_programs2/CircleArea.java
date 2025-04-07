
class Area {

    private int radius;

    // constructor to initialize values
    Area(int radius) {
        this.radius = radius;
    }

    // method to calculate area
    public void getArea() {
        Double area = 3.14 * radius * radius;
        System.out.println("Area: " + area);
    }
}

class CircleArea {
    public static void main(String[] args) {

        Area circle = new Area(5);
        circle.getArea();
    }
}
