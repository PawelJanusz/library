import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        mainMenu();

    }
    static List<Book> book1List = new LinkedList<>();
    static List<Book> book3List = Arrays.asList(new Book("quo vadis", "Henryk Sienkiewicz", 400 ),
            new Book("clean code", "Robert Martin", 250),
            new Book("headway", "Liz Soars", 80));

    static List<Reader> readerList = Collections.singletonList(new Reader("Adam", "Nowak", 23, 654789346, book1List));

    static Book book = new Book("clean code", "Robert Martin", 250);
    static Library library = new Library();
    static Reader reader = new Reader("Adam", "Nowak", 23, 654789346, book1List);



    static Scanner scanner = new Scanner(System.in);
    static String command;

    static void mainMenu() {
        do {
            System.out.println("Choose option number: \n" +
                    "1.Add reader \n" +
                    "2.Print all books in library \n" +
                    "3.Print library clients \n" +
                    "4.Change phone number \n" +
                    "5.Remove user and books from library \n" +
                    "6.Borrow book \n" +
                    "7.Print borrowed books \n" +
                    "8.Return book \n" +
                    "10.Quit");
            command = scanner.nextLine();
            if (command.equals("1")) {
                library.createUser(reader);
            }
            if (command.equals("2")) {
                library.readBooks();
            }
            if (command.equals("3")) {
                library.readUsers();
            }
            if (command.equals("4")){
                reader.changePhoneNumber(987576465);
            }
            if (command.equals("5")){
                reader.removeUser(library);
            }
            if (command.equals("6")){
                reader.borrowBook(book3List.get(2), library);
            }
            if (command.equals("7")){
                reader.readBorrowedBooks();
            }
            if (command.equals("8")){
                reader.returnBook(book3List.get(2),library);
            }
        } while (!command.equals("10"));
    }
}

