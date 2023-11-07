import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Search implements Serializable, SearchInterface  {

    @Override
    public List<Contact> surnameSearch(String surname){
        List<Contact> matchingSurname = new ArrayList<>();

            for (Contact contact : PhoneBook.getInstance().getContacts()) {
                if (surname.equalsIgnoreCase(contact.getSurname())){
                    matchingSurname.add(contact);
                    break;
                }
            } return matchingSurname;
    }

    @Override
    public List<Contact> addressSearch(String searchAddress){
        List<Contact> matchingAddress = new ArrayList<>();

        for (Contact contact : PhoneBook.getInstance().getContacts()){
            if (contact.getAddress().getStreetName().equalsIgnoreCase(searchAddress)){
                matchingAddress.add(contact);
            }
        } return matchingAddress;
    }

    @Override
    public List<Contact> firstnameSearch(String firstname){
        List<Contact> matchingFirstName = new ArrayList<>();

        for (Contact contact : PhoneBook.getInstance().getContacts()) {
            if (firstname.equalsIgnoreCase(contact.getFirstname())){
                matchingFirstName.add(contact);
            }
        } return matchingFirstName;
    }
@Override
    public List<Contact> freeSearch(String userSearch){
        List<Contact> matchingFree = new ArrayList<>();

        for (Contact contact : PhoneBook.getInstance().getContacts()) {
            if (contact.getInfo().toLowerCase().contains(userSearch.toLowerCase())){
                matchingFree.add(contact);
            }
        } return matchingFree;
    }


}
