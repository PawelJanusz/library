public class Book {

    String title;
    String author;
    int pages;

    Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public void readBook(){
        System.out.println("Title: "+title+" / Author: "+author+" / Pages: "+pages);
    }
}
