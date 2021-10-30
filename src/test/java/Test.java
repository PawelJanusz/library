
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class Test {

    @org.junit.Test
    @DisplayName("Add the reader to the library clients")
    public void testAddingToClients() {
        List<Book> books = new ArrayList<>();
        List<Book> booksLib = new ArrayList<>();
        List<Reader> readers = new ArrayList<>();
        Reader reader = new Reader("Casual", "Guy", 20, 111111111, books);
        Library lib = new Library(readers, booksLib);
        lib.createUser(reader);
        assertEquals(1, readers.size());
    }

    @org.junit.Test
    @DisplayName("Try to add the reader with wrong name to the library clients")
    public void testTryingAddToClients() {
        List<Book> books = new ArrayList<>();
        List<Book> booksLib = new ArrayList<>();
        List<Reader> readers = new ArrayList<>();
        Reader reader = new Reader("Casu4l", "5uy", 20, 111111111, books);
        Library lib = new Library(readers, booksLib);
        lib.createUser(reader);
        assertEquals(0, readers.size());
    }

    @org.junit.Test
    @DisplayName("Try to add the reader with wrong number to the library clients")
    public void testTryingAddToClients2() {
        List<Book> books = new ArrayList<>();
        List<Book> booksLib = new ArrayList<>();
        List<Reader> readers = new ArrayList<>();
        Reader reader = new Reader("Casual", "Guy", 20, 1111111, books);
        Library lib = new Library(readers, booksLib);
        lib.createUser(reader);
        assertEquals(0, readers.size());
    }

    @org.junit.Test
    @DisplayName("Give the book to the reader and remove the book from the library")
    public void testBorrowBook() {
        List<Book> books = new ArrayList<>();
        List<Book> booksLib = new ArrayList<>();
        List<Reader> readers = new ArrayList<>();
        Book book1 = new Book("Book1", "Author1", 12);
        Book book2 = new Book("Book2", "Author2", 13);
        booksLib.add(book1);
        booksLib.add(book2);
        Reader reader = new Reader("Casual", "Guy", 20, 111111111, books);
        Library lib = new Library(readers, booksLib);
        lib.createUser(reader);
        reader.borrowBook(book1, lib);
        assertEquals(1, books.size());
        assertEquals(1, booksLib.size());
        assertEquals("Book1", books.get(0).title);
        assertEquals("Book2", booksLib.get(0).title);
    }

    @org.junit.Test
    @DisplayName("Try to borrow fourth book")
    public void testTryToBorrowFourthBook() {
        List<Book> books = new ArrayList<>();
        List<Book> booksLib = new ArrayList<>();
        List<Reader> readers = new ArrayList<>();
        Book book1 = new Book("Book1", "Author1", 12);
        Book book2 = new Book("Book2", "Author2", 13);
        Book book3 = new Book("Book3", "Author3", 11);
        Book book4 = new Book("Book4", "Author4", 18);
        booksLib.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        Reader reader = new Reader("Casual", "Guy", 20, 111111111, books);
        Library lib = new Library(readers, booksLib);
        lib.createUser(reader);
        reader.borrowBook(book1, lib);
        assertEquals(3, books.size());
        assertEquals(1, booksLib.size());
    }

    @org.junit.Test
    @DisplayName("Remove the book from reader's collection and give it back to library")
    public void testReturnBook() {
        List<Book> books = new ArrayList<>();
        List<Book> booksLib = new ArrayList<>();
        List<Reader> readers = new ArrayList<>();
        Book book1 = new Book("Book1", "Author1", 12);
        Book book2 = new Book("Book2", "Author2", 13);
        booksLib.add(book1);
        books.add(book2);
        Reader reader = new Reader("Casual", "Guy", 20, 111111111, books);
        Library lib = new Library(readers, booksLib);
        lib.createUser(reader);
        reader.returnBook(book2, lib);
        assertEquals(0, books.size());
        assertEquals(2, booksLib.size());
    }

    @org.junit.Test
    @DisplayName("Remove the reader from the library clients")
    public void testRemoveReader() {
        List<Book> books = new ArrayList<>();
        List<Book> booksLib = new ArrayList<>();
        List<Reader> readers = new ArrayList<>();
        Reader reader = new Reader("Casual", "Guy", 20, 111111111, books);
        Library lib = new Library(readers, booksLib);
        lib.createUser(reader);
        reader.removeUser(lib);
        assertEquals(0, readers.size());
    }

    @org.junit.Test
    @DisplayName("Try to remove the reader which hasn't retured all the books")
    public void testRemoveReader2() {
        List<Book> books = new ArrayList<>();
        List<Book> booksLib = new ArrayList<>();
        List<Reader> readers = new ArrayList<>();
        Book book1 = new Book("Book1", "Author1", 554);
        books.add(book1);
        Reader reader = new Reader("Casual", "Guy", 20, 111111111, books);
        Library lib = new Library(readers, booksLib);
        lib.createUser(reader);
        reader.removeUser(lib);
        assertEquals(1, readers.size());
    }

    @org.junit.Test
    @DisplayName("Change the reader's phone number")
    public void testChangePhoneNumber() {
        List<Book> books = new ArrayList<>();
        List<Book> booksLib = new ArrayList<>();
        List<Reader> readers = new ArrayList<>();
        Reader reader = new Reader("Casual", "Guy", 20, 111111111, books);
        Library lib = new Library(readers, booksLib);
        lib.createUser(reader);
        reader.changePhoneNumber(444555333);
        assertEquals(444555333, reader.phoneNumber);
    }

    @org.junit.Test
    @DisplayName("Try to change the reader's phone number")
    public void testChangePhoneNumber2() {
        List<Book> books = new ArrayList<>();
        List<Book> booksLib = new ArrayList<>();
        List<Reader> readers = new ArrayList<>();
        Reader reader = new Reader("Casual", "Guy", 20, 111111111, books);
        Library lib = new Library(readers, booksLib);
        lib.createUser(reader);
        reader.changePhoneNumber(44455333);
        assertEquals(111111111, reader.phoneNumber);
    }
}

