import java.util.LinkedList;
import java.util.List;

public class Reader {
     /*The class represents a single reader
    Contains the following variables:
    -name as String
    -surname as String
    -age as int
    -phoneNumber as int
    -books as the list of Book objects (the books that reader borrowed)

    */
    String name;
    String surname;
    int age;
    int phoneNumber;
    List<Book> books = new LinkedList<>();

    //Constructor
    public Reader(String name, String surname, int age, int phoneNumber, List<Book> books) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.books = books;
    }

//    public Reader(String name, String surname, int age, int phoneNumber) {
//        this.name = name;
//        this.surname = surname;
//        this.age = age;
//        this.phoneNumber = phoneNumber;
//    }

    //Print on the screen information about a single reader
    public void readUser(){
        System.out.println("Name: "+name+" / Surname: "+surname);
        System.out.println("Age: "+age+" / Phone number: "+phoneNumber);
        System.out.println("Borrowed books: "+books.size());
    }

    //Print on the screen all borrowed books
    public void readBorrowedBooks(){
        for(Book br : books){
            br.readBook();
        }
    }

    //Remove the reader from the library clients
    public void removeUser(Library lib){
        Reader reader = new Reader(name, surname, age, phoneNumber, books);
        if (books.size() != 0){
            System.out.println("You haven't return all the books yet");
        }
        if (books.size() == 0) {
            lib.readers.clear();
            System.out.println("You've deleted your account");
        }
        //Check if the reader has returned all the books.
        //If the reader hasn't returned all the books, print a message "You haven't return all the books yet".
        //If the reader has returned all the books, remove them from the library clients (the list of readers in the class Library)
        //and print a message "You've deleted your account".
    }

    public void borrowBook(Book book, Library lib){
        if (books.size() == 3){
            System.out.println("You can't have more than three books borrowed");
        }
        if (books.size() < 3){
            books.add(book);
            lib.books.remove(book);
            System.out.println("You've borrowed: " + book.title);
        }
        //If the reader already has three books borrowed, don't let them borrow this book
        //and print a message "You can't have more than three books borrowed".
        //If the reader has less than three books borrowed,
        //add the book to their list of books and remove it from the library (the list of books in the class Library)
        //and print a message "You've borrowed <book title>".
    }

    public void returnBook(Book book, Library lib){
        books.remove(book);
        lib.books.add(book);
        //Remove the given book from the reader's  books
        //and add it back to the library's books
    }

    public void changePhoneNumber(int phoneNumber){
        int counter = 0;
        for (int i=0; i<String.valueOf(phoneNumber).length(); i++){
            counter++;
        }
        if (counter != 9){
            System.out.println("Wrong phone number");
        }
        else
            this.phoneNumber = phoneNumber;
        //If the given number has exactly 9 digits, change the reader's number
        //Otherwise print a message "Wrong phone number".
    }
}
