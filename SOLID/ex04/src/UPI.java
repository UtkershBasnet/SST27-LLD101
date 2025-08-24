public class UPI implements PaymentProvider {
    public String pay(double amount) {
        return "Paid via UPI: " + amount;
    }
}
