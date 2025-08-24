public class Overnight implements ShipmentType {
    Shipment s;
    public Overnight(Shipment s){
        this.s = s;
    }
    @Override
    public double cost() {
        return 120 + 10 * s.weightKg;
    }
}
