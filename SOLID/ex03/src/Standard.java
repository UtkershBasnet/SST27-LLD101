public class Standard implements ShipmentType {
    Shipment s;
    public Standard(Shipment s){
        this.s = s;
    }
    @Override
    public double cost() {
        return 50 + 5 * s.weightKg;
    }
    
}
