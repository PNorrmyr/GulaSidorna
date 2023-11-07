public class Main {
    public static void main(String[] args) {

        PhoneBook.readFromFile("phonebook.ser");
        PhoneBook phoneBook = PhoneBook.getInstance();


        UI ui = new UI();
        ui.initialize();



    }
}







