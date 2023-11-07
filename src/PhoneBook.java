import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneBook implements Serializable {

    private final List<Contact> contacts = new ArrayList<>();
    private final Search search = new Search();

    private static PhoneBook instance;

    private PhoneBook(){}

    public static PhoneBook getInstance(){
        if (instance == null){
            instance = new PhoneBook();
        }
        return instance;
    }

    public void saveToFile(){
        try {
            FileOutputStream fileOut = new FileOutputStream("phonebook.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
        } catch (IOException i){
            i.printStackTrace();
        }
    }

    public static void readFromFile(String filename){
        PhoneBook phoneBook = null;
        try {
            FileInputStream fileIn = new FileInputStream("phonebook.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            instance = (PhoneBook) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i){
            i.printStackTrace();
        } catch (ClassNotFoundException c){
            System.out.println("PhoneBook class not found");
            c.printStackTrace();
        }
    }

    public void addContact(Contact contact){
        contacts.add(contact);
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void removeContact(Contact contact){
        contacts.remove(contact);
    }

    public Boolean deleteContact (String userInput) {
        List<Contact> matchingContact = search.freeSearch(userInput);
        if (!matchingContact.isEmpty()){
            removeContact(matchingContact.get(0));
            matchingContact = search.freeSearch(userInput);
            return matchingContact.isEmpty();
        } else {
            return false;
        }
    }


    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (Contact contact : contacts) {
            out.append(contact);
        }
        return out.toString();
    }
}
