
public class PaymentService {
    String pay(PaymentProvider provider, double amount) {
        return provider.pay(amount); 
    }
}