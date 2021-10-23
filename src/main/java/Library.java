import java.util.LinkedList;
import java.util.List;

public class Library {

    List<Reader> readers = new LinkedList<>();
    List<Book> books = new LinkedList<>();

    Library(List<Reader> readers, List<Book> books) {
        this.readers = readers;
        this.books = books;
    }

    public Library() {
    }

    //Check if the name and surname contain only letters.
    //If they don't, print a message "Wrong name or surname".
    //Check if the reader's number has exactly 9 digits.
    //If it doesn't, print a message "Wrong phone number".
    //If the data are correct, add the given reader to the library clients (the list readers)
    //and print a message "You have added: <reader name> <reader surname>".
    public void createUser(Reader reader) {
        boolean flag = true;
        for (int i = 0; i <=reader.name.length()-1; i++) {
            if (!Character.isLetter(reader.name.charAt(i))) {
                flag = false;
                System.out.println("Wrong name");
            }
        }
        for (int i = 0; i <reader.surname.length(); i++) {
            if (!Character.isLetter(reader.surname.charAt(i))) {
                flag = false;
                System.out.println("Wrong surname");
            }
        }
        int counter = 0;
        for (int i=0; i<String.valueOf(reader.phoneNumber).length(); i++){
            counter++;
        }
        if (counter != 9){
            flag = false;
            System.out.println("Wrong phone number");
        }

        if (flag) {
            readers.add(reader);
            System.out.println("You have added: " + reader.name + " " + reader.surname);
        }
    }

    //Print on the screen all the books in the library
    public void readBooks(){
        for(Book bk : books){
            bk.readBook();
        }
    }

    //Print on the screen all the library clients
    public void readUsers(){
        for(Reader rd : readers){
            rd.readUser();
        }
    }
}
