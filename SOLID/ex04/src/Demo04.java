
public class Demo04 {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();
        UPI upi = new UPI();
        System.out.println(service.pay(upi, 499));
    }
}
