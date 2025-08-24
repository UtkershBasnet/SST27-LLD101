public class Demo07 {
    public static void main(String[] args) {
        Printer p = new BasicPrinter();
        p.print("Hello");
        // p.scan("/tmp/out"); // Not supported by BasicPrinter
    }
}
