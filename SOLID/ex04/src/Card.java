public class Card implements PaymentProvider {
    public String pay(double amount) {
        return "Charged card: " + amount;
    }
}
