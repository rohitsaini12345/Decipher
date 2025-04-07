
class Area {

    private int side;

    // constructor to initialize values
    Area(int side) {
        this.side = side;
    }

    // method to calculate area
    public void getArea() {
        int area = side * side;
        System.out.println("Area: " + area);
    }
}

class SquareArea {
    public static void main(String[] args) {

        Area square = new Area(5);
        square.getArea();
    }
}