

public class Demo01 {
    public static void main(String[] args) {
        EmailClient emailClient = new EmailClient();
        CurrentTax currentTax = new CurrentTax();
        CurrentDB currentDB = new CurrentDB();
        new OrderService(emailClient, currentTax, currentDB).checkout("a@shop.com", 100.0); 
    }
}
