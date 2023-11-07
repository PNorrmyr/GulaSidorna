import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Contact implements Serializable {
    private String firstname;
    private String surname;
    private int age;
    private Address address;
    private final List<String> phoneNumbers;

    private Contact(ContactBuilder builder){
        this.firstname = builder.firstname;
        this.surname = builder.surname;
        this.age = builder.age;
        this.address = builder.address;
        this.phoneNumbers = builder.phoneNumbers;
    }

    public static class ContactBuilder{
        private String firstname;
        private String surname;
        private int age;
        private Address address;
        private List<String> phoneNumbers = new ArrayList<>();
        public ContactBuilder(){}

        public ContactBuilder firstname(String firstname){
            this.firstname = firstname;
            return this;
        }
        public ContactBuilder surname(String surname){
            this.surname = surname;
            return this;
        }
        public ContactBuilder age(int age){
            this.age = age;
            return this;
        }
        public ContactBuilder address(Address address){
            this.address = address;
            return this;
        }
        public ContactBuilder phoneNumber(List<String> phoneNumbers){
            this.phoneNumbers = phoneNumbers;
            return this;
        }

        public Contact build(){
            return new Contact(this);
        }

    }

    public static Contact createContact () {
        ContactInput input = UI.contactInputUI();

        return new Contact.ContactBuilder()
                .firstname(input.getInputFirstname())
                .surname(input.getInputSurname())
                .age(input.getInputAge())
                .address(input.getInputAddress())
                .phoneNumber(input.getInputPhoneNumbers())
                .build();
    }

    public String getSurname() {
        return surname;
    }
    public String getFirstname() {
        return firstname;
    }
    public Address getAddress() {
        return address;
    }
    public List<String> getPhoneNumbers() {return phoneNumbers;}
    public String getInfo(){return getFirstname() + " " + getSurname() + " " + getAddress() + " " + getPhoneNumbers();}
    public void setFirstname(String newFirstname){this.firstname = newFirstname;}
    public void setSurname(String newSurname){
        this.surname = newSurname;
    }
    public void setAge(int newAge){
        this.age = newAge;
    }
    public void setAddress(Address newAddress){this.address = newAddress;}
    public void addPhoneNumber(String newPhoneNumber){
        this.phoneNumbers.add(newPhoneNumber);
    }
    public void removePhoneNumber(int i){
        this.phoneNumbers.remove(i);
    }

    @Override
    public String toString() {
        return  "Name: " + firstname + " " + surname +
                "\n   Age: " + age +
                "\n   Address: " + address +
                "\n   Phone number(s): " + phoneNumbersToString() + "\n";
    }

    public String phoneNumbersToString(){
        return String.join(", ",phoneNumbers);
    }
}
