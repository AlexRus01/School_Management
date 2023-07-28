package Model;

public class Address {

    private Integer id_address;
    private String city;
    private String street;
    private Integer number;

    public Address(){
    }
    public Address(Integer id_address, String city, String street, Integer number) {
        this.id_address = id_address;
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public void setId_address(Integer id_address) {
        this.id_address = id_address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getId_address() {
        return id_address;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public Integer getNumber() {
        return number;
    }
}
