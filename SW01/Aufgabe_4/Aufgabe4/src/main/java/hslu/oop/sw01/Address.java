package hslu.oop.sw01;

public class Address {

    private String streetname;
    private String houseNr;
    private String city;
    private String state;
    private String zipcode;

    Address(String streetname, String houseNr, String city, String state, String zipcode) {
        this.streetname = streetname;
        this.houseNr = houseNr;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public String getHouseNr() {
        return houseNr;
    }

    public void setHouseNr(String houseNr) {
        this.houseNr = houseNr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
