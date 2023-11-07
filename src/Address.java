import java.io.Serializable;

public class Address implements Serializable {

    private final String city;
    private final String zipCode;
    private final String streetName;
    private final String streetNumber;

    private Address(AddressBuilder builder){
        this.city = builder.city;
        this.zipCode = builder.zipCode;
        this.streetName = builder.streetName;
        this.streetNumber = builder.streetNumber;
    }

    public static class AddressBuilder{
        private String city;
        private String zipCode;
        private String streetName;
        private String streetNumber;
        public AddressBuilder(){}

        public AddressBuilder city(String city){
            this.city = city;
            return this;
        }
        public AddressBuilder zipcode(String zipCode){
            this.zipCode = zipCode;
            return this;
        }
        public AddressBuilder streetName(String streetName){
            this.streetName = streetName;
            return this;
        }
        public AddressBuilder streetNumber(String streetNumber){
            this.streetNumber = streetNumber;
            return this;
        }

        public Address build(){
            return new Address(this);
        }

    }


    public static Address createAddress () {
        AddressInput input = UI.addressInputUI();

        return new Address.AddressBuilder()
                .city(input.getInputCity())
                .zipcode(input.getInputZipCode())
                .streetName(input.getInputStreetName())
                .streetNumber(input.getInputStreetNumber())
                .build();
    }


    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getFullAddress(){
        return  getStreetName() + " " + getStreetNumber() + " " + getZipCode() + " " + getCity();
    }

    @Override
    public String toString() {
        return getFullAddress();
    }
}
