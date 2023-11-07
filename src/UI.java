
import Users.Administrator;

import java.util.ArrayList;
import java.util.List;

public class UI {
    private final PhoneBook phoneBook = PhoneBook.getInstance();
    private final Search search = new Search();
    private boolean isDone = false;


    public void initialize() {
        while (!isDone) {
            Out.mainMenu();
            String input = In.scannerString();
            //if quit is typed stops program
            if (input.equalsIgnoreCase("QUIT")){
                phoneBook.saveToFile();
                isDone = true;
                continue;
            }

//          convert input to integer named option
            int option = Integer.parseInt(input);

//          Option search Contacts
            if (option == 1) {
                Out.searchMenu();
                int userSearchOption = In.scannerInt();
                Out.printSearchResult(searchUI(userSearchOption));
            }

//          Option Administrator
            else if (option == 2) {
                administratorUI();
            }
        }
    }

        public void administratorUI(){
            boolean isAdmin = false;

            // asks for username and password of admin
            Out.promptAdminUsername();
            String username = In.scannerString();
            Out.promptAdminPassword();
            String password = In.scannerString();

            while (!isAdmin) {
                //Checks admin login, if correct opens Admin Menu otherwise returns to Main Menu
                if (Administrator.isLoginCorrect(username,password)) {
                    Out.adminMenu();
                    String userQuit = In.scannerString();

                    //If user types quit, program ends
                    if (userQuit.equalsIgnoreCase(("QUIT"))) {
                        phoneBook.saveToFile();
                        isAdmin = true;
                        isDone = true;
                        continue;
                    }

                    int userOption = Integer.parseInt(userQuit);

                    //Options for administrator
                    switch (userOption) {

                        //SearchMenu
                        case 1:
                            Out.searchMenu();
                            int userSearchOption = In.scannerInt();
                            Out.printSearchResult(searchUI(userSearchOption));
                            break;

                        //Create and add contact to phonebook
                        case 2:
                            phoneBook.addContact(Contact.createContact());
                            Out.printContactAdded();
                            break;

                        //Update contact
                        case 3:
                            Out.promptUpdateContact();
                            String contactToUpdate = In.scannerString();
                            updateUI(contactToUpdate);
                            break;

                        //Delete contact
                        case 4:
                            Out.promptDeleteContact();
                            String userInput = In.scannerString();
                            if (phoneBook.deleteContact(userInput)){
                                Out.printContactDeleted(userInput);
                            } else {
                                Out.printContactNotFound();
                            }
                            break;

                        default:
                            Out.printInvalidOption();

                    }
                } else {
                    Out.printWrongLogin();
                    isAdmin = true;
                }
            }
        }


    public void updateUI(String contactToUpdate){

        //Finds contact to update, if multiple contacts found user chooses one.
        Contact contact = null;
        List<Contact> matchingContacts = search.freeSearch(contactToUpdate);
        if(matchingContacts.isEmpty()){
            Out.printContactNotFound();
        }
        if(matchingContacts.size() != 1){
            Out.printSearchResult(matchingContacts);
            Out.promptChooseContact();
            int chosenContact = In.scannerInt();
            contact = matchingContacts.get(chosenContact-1);
        } else {
            contact = matchingContacts.get(0);
        }

        //User chooses what to update
        Out.updateContactMenu();
        int userOption = In.scannerInt();

        if (contact != null) {

            switch (userOption) {
                //Updates firstname
                case 1:
                    Out.promptUpdateFirstname();
                    String newFirstname = In.scannerString();
                    contact.setFirstname(newFirstname);
                    Out.printFirstnameChanged(newFirstname);
                    break;

                //Updates Surname
                case 2:
                    Out.promptUpdateSurname();
                    String newSurname = In.scannerString();
                    contact.setSurname(newSurname);
                    Out.printSurnameChanged(newSurname);
                    break;

                //Updates age
                case 3:
                    Out.promptUpdateAge();
                    int newAge = In.scannerInt();
                    contact.setAge(newAge);
                    Out.printAgeChanged(newAge);
                    break;

                //Updates address
                case 4:
                    Address newAddress = Address.createAddress();
                    contact.setAddress(newAddress);
                    Out.printAddressChanged(newAddress.getFullAddress());
                    break;

                //Updates phonenumber
                case 5:
                    Out.promptUpdatePhoneNumber();
                    String option = In.scannerString();

                    //Adds number
                    if (option.equalsIgnoreCase("ADD")) {
                        Out.promptAddNewPhoneNumber();
                        String newPhonenumber = In.scannerString();
                        contact.addPhoneNumber(newPhonenumber);
                        Out.printPhoneNumberAdded(newPhonenumber);
                    }

                    //Removes number
                    else if (option.equalsIgnoreCase("REMOVE")) {
                        Out.printPhoneNumbers(contact.getPhoneNumbers());
                        Out.promptRemovePhoneNumber();
                        int numberToRemove = In.scannerInt();
                        contact.removePhoneNumber(numberToRemove-1);
                        Out.printPhoneNumberRemoved();
                    }
                    break;
            }
        }
    }

    public List<Contact> searchUI(int userSearchOption) {
        String userSearch;

        switch (userSearchOption) {

            //Search by first name
            case 1:
                Out.promptSearchFirstname();
                userSearch = In.scannerString();
                return search.firstnameSearch(userSearch);

            //Search by surname
            case 2:
                Out.promptSearchSurname();
                userSearch = In.scannerString();
                return search.surnameSearch(userSearch);

            // Search by address
            case 3:
                Out.promptSearchAddress();
                userSearch = In.scannerString();
                return search.addressSearch(userSearch);

            //Freesearch
            case 4:
                Out.promptSearchFree();
                userSearch = In.scannerString();
                return search.freeSearch(userSearch);

            default:
                Out.printInvalidOption();
                break;
        }
        return null;
    }



    public static ContactInput contactInputUI(){
        Out.promptFirstname();
        String inputFirstname = In.scannerString();
        Out.promptSurname();
        String inputSurname = In.scannerString();
        int inputAge = checkAgeNumberUI();

        Out.promptPhoneNumber();
        List<String> inputPhoneNumbers = new ArrayList<>();
        inputPhoneNumbers.add(In.scannerString());

        Out.promptAddPhoneNumbers();
        boolean additionalNumbers = false;
        while (!additionalNumbers){
            if (In.scannerString().equalsIgnoreCase("YES")){
                Out.promptPhoneNumber();
                inputPhoneNumbers.add(In.scannerString());
                Out.promptAddPhoneNumbers();
            } else {
                additionalNumbers = true;
            }
        }

        Address inputAddress = Address.createAddress();

        return new ContactInput(inputFirstname, inputSurname, inputAge, inputAddress, inputPhoneNumbers);
    }


    public static AddressInput addressInputUI(){
        Out.promptStreetName();
        String inputStreetName = In.scannerString();
        Out.promptStreetNumber();
        String inputStreetNumber = In.scannerString();
        Out.promptZipCode();
        String inputZipCode = In.scannerString();
        Out.promptCity();
        String inputCity = In.scannerString();
        return new AddressInput(inputStreetName, inputStreetNumber, inputZipCode, inputCity);
    }



    private static int checkAgeNumberUI(){
        while (true) {
            try {
                Out.promptAge();
                return In.scannerInt();
            } catch (NumberFormatException e) {
                Out.printNotNumber(); // En metod som skriver ut ett felmeddelande
            }
        }
    }

}

