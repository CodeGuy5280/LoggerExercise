public class Shipper {
    private int shipperId;
    private String shipperName;
    private String shipperPhone;

    public Shipper(String shipperName, String shipperPhone) {
        this.shipperName = shipperName;
        this.shipperPhone = shipperPhone;
    }

    public int getShipperId() {
        return shipperId;
    }

    public void setShipperId(int shipperId) {
        this.shipperId = shipperId;
    }

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public String getShipperPhone() {
        return shipperPhone;
    }

    public void setShipperPhone(String shipperPhone) {
        this.shipperPhone = shipperPhone;
    }
}
