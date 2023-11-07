import java.util.List;

public interface SearchInterface {


    List<Contact> surnameSearch(String surname);

    List<Contact> addressSearch(String searchAddress);

    List<Contact> firstnameSearch(String firstname);

    List<Contact> freeSearch(String userSearch);

}
