public class CurrentTax implements TaxCalculator{
    double taxRate = 0.18;
    public double totalWithTax(double amount) {
        return amount + amount * taxRate;
    }
}
