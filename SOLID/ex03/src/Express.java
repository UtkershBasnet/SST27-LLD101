public class Express implements ShipmentType {
    Shipment s;
    public Express(Shipment s){
        this.s = s;
    }
    @Override
    public double cost() {
        return 80 + 8 * s.weightKg;
    }
}
