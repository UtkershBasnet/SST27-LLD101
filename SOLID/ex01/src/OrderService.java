public class OrderService {
    Notifier notifier;
    TaxCalculator taxCalculator;
    Database database;
    
    public OrderService(Notifier notifier, TaxCalculator taxCalculator ,Database database) {
        this.notifier = notifier;
        this.taxCalculator = taxCalculator;
        this.database = database;
    }
    
    void checkout(String customerEmail, double subtotal) {
        double total = taxCalculator.totalWithTax(subtotal);
        notifier.send(customerEmail, "Thanks! Your total is " + total);
        database.printOrder();
    }
}