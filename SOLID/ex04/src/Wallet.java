public class Wallet implements PaymentProvider {
    public String pay(double amount) {
        return "Wallet debit: " + amount;
    }
}
