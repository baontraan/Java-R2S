public class Test {

    public static void main(String[] args) {
        Circle c = new Circle();

        c.radius = 12;

        System.out.println(String.format("Area of the circle %.2f", c.getArea()));
    }
}
