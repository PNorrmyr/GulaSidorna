public class AddressInput {
    private final String inputCity;
    private final String inputZipCode;
    private final String inputStreetName;
    private final String inputStreetNumber;

    public AddressInput(String inputStreetName, String inputStreetNumber, String inputZipCode, String inputCity) {
        this.inputCity = inputCity;
        this.inputZipCode = inputZipCode;
        this.inputStreetName = inputStreetName;
        this.inputStreetNumber = inputStreetNumber;
    }


    public String getInputCity() {
        return inputCity;
    }

    public String getInputZipCode() {
        return inputZipCode;
    }

    public String getInputStreetName() {
        return inputStreetName;
    }

    public String getInputStreetNumber() {
        return inputStreetNumber;
    }




}
