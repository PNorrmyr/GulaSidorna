import java.util.List;

public abstract class Out {

    //Console menus
    public static void mainMenu(){
        System.out.println("""
                            Phonebook
                Choose one of the following options
                1. Search Contacts
                2. Administrator
                Type quit to end.""");
    }
    public static void adminMenu(){
        System.out.println("""
                        Administrator Menu
                1. Search Contacts
                2. Create new Contact
                3. Update Contact
                4. Delete Contact
                Type quit to end""");
    }
    public static void searchMenu(){
        System.out.println("""
                        Search Contact
                Choose to search by,
                1. First name
                2. Surname
                3. Address
                4. Free search""");
    }
    public static void updateContactMenu(){
        System.out.println("""
                What would you like to update,
                1. Firstname
                2. Surname
                3. Age
                4. Address
                5. Phonenumber""");
    }



    //Prompts
    public static void promptAdminUsername(){
        System.out.println("Type in username: ");
    }
    public static void promptAdminPassword(){
        System.out.println("Type in password: ");
    }
    public static void promptFirstname(){
        System.out.println("Type in firstname of contact: ");
    }
    public static void promptSurname(){
        System.out.println("Type in surname: ");
    }
    public static void promptAge(){
        System.out.println("Type in age: ");
    }
    public static void promptStreetName(){
        System.out.println("Type in street name: ");
    }
    public static void promptStreetNumber(){System.out.println("Type in street number: ");}
    public static void promptZipCode(){System.out.println("Type in zip code: ");}
    public static void promptCity(){System.out.println("Type in city: ");}
    public static void promptPhoneNumber(){
        System.out.println("Type in phone number: ");
    }
    public static void promptAddPhoneNumbers(){System.out.println("Would you like to add another telephone number?");}
    public static void promptSearchSurname(){
        System.out.println("Type in surname of contact: ");
    }
    public static void promptSearchFirstname(){
        System.out.println("Type in first name of contact: ");
    }
    public static void promptSearchAddress(){
        System.out.println("Type in street name of contact: ");
    }
    public static void promptSearchFree(){
        System.out.println("Type in search word: ");
    }
    public static void promptChooseContact(){
        System.out.println("Which contact would you like to choose: ");
    }
    public static void promptDeleteContact(){System.out.println("Type in full name of contact you would like to delete: ");}
    public static void promptUpdateContact(){System.out.println("Type in full name of contact you would like to update: ");}
    public static void promptUpdateFirstname(){
        System.out.println("Type in new firstname: ");
    }
    public static void promptUpdateSurname(){
        System.out.println("Type in new surname: ");
    }
    public static void promptUpdateAge(){System.out.println("Type in new age: ");}
    public static void promptUpdatePhoneNumber(){System.out.println("Add new or remove existing phone number(s)? ");}
    public static void promptAddNewPhoneNumber(){System.out.println("Type in new phone number: ");}
    public static void promptRemovePhoneNumber(){System.out.println("Which number would you like to delete?");}



    //Prints
    public static void printWrongLogin(){
        System.out.println("Wrong login details\n");
    }
    public static void printPhoneNumberAdded(String newPhoneNumber){System.out.println(newPhoneNumber + " added to contact");}
    public static void printPhoneNumberRemoved(){System.out.println("Phone number removed");}
    public static void printAddressChanged(String newAddress){System.out.println("Address changed to " + newAddress);}
    public static void printAgeChanged(int newAge){System.out.println("Age changed to " + newAge);}
    public static void printSurnameChanged(String newSurname){System.out.println("Surname changed to " + newSurname);}
    public static void printFirstnameChanged(String newFirstname){System.out.println("Firstname changed to " + newFirstname);}
    public static void printNotNumber(){System.out.println("Not a number, try again");}
    public static void printInvalidOption(){System.out.println("Invalid option");}
    public static void printContactAdded(){System.out.println("Contact added\n");}
    public static void printContactDeleted(String name){System.out.println(name + " deleted from phonebook\n");}
    public static void printContactNotFound(){System.out.println("\n      Contact not found\n");}
    public static void printSearchResult(List<Contact> foundContacts){
        if (foundContacts != null && !foundContacts.isEmpty()){
            for (int i = 0; i < foundContacts.size(); i++) {
                System.out.println(i+1 + ". " + foundContacts.get(i));
            }
        } else {
            printContactNotFound();
        }
    }
    public static void printPhoneNumbers(List<String> phoneNumbers){
        for (int i = 0; i < phoneNumbers.size(); i++) {
            System.out.println(i+1 + ". " + phoneNumbers.get(i));
        }
    }

}
