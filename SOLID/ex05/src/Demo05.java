public class Demo05 {
    static int areaAfterResize(Shape s) {
        return s.area();
    }

    public static void main(String[] args) {
        Shape rect = new Rectangle(5, 4);
        Shape square = new Square(4);

        System.out.println(areaAfterResize(rect));   // 20
        System.out.println(areaAfterResize(square)); // 16
    }
}
