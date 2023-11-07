import java.util.ArrayList;
import java.util.List;

public class ContactInput {

    private final String inputFirstname;
    private final String inputSurname;
    private final int inputAge;
    private final Address inputAddress;
    private final List<String> inputPhoneNumbers;

    public ContactInput(String inputFirstname, String inputSurname, int inputAge, Address inputAddress, List<String> inputPhoneNumbers){
        this.inputFirstname = inputFirstname;
        this.inputSurname = inputSurname;
        this.inputAge = inputAge;
        this.inputAddress = inputAddress;
        this.inputPhoneNumbers = inputPhoneNumbers;
    }


    public String getInputFirstname() {
        return inputFirstname;
    }

    public String getInputSurname() {
        return inputSurname;
    }

    public int getInputAge() {
        return inputAge;
    }

    public Address getInputAddress() {
        return inputAddress;
    }

    public List<String> getInputPhoneNumbers() {
        return inputPhoneNumbers;
    }

}
