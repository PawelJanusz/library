public class Book {
    //The class that represents a single book
    //Contains the following variables:
    //-title as String
    //-author as String
    //-pages as int

    String title;
    String author;
    int pages;

    //Constructor
    Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    //Print a single book on the screen
    public void readBook(){
        System.out.println("Title: "+title+" / Author: "+author+" / Pages: "+pages);
    }
}
