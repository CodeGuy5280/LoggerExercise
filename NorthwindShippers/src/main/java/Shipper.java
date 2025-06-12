public class Shipper {
    private String shipperName;
    private int shipperPhone;

    public Shipper(String shipperName, int shipperPhone){
        this.shipperName = shipperName;
        this.shipperPhone = shipperPhone;
    }

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public int getShipperPhone() {
        return shipperPhone;
    }

    public void setShipperPhone(int shipperPhone) {
        this.shipperPhone = shipperPhone;
    }
}
