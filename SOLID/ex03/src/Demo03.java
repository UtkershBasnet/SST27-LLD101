public class Demo03 {
    public static void main(String[] args) {
        Express e = new Express(new Shipment( 2.0));
        System.out.println(e.cost());
    }
}
