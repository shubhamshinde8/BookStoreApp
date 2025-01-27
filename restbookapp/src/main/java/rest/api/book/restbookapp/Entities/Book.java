package rest.api.book.restbookapp.Entities;


public class Book {
    
    private int bookId;

    private String bookName;

    private String bookAuthorName;

    private int bookPrice;

    public Book(int bookId, String bookName, String bookAuthorName, int bookPrice) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthorName = bookAuthorName;
        this.bookPrice = bookPrice;
    }

    

    public Book() {
    }



    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthorName() {
        return bookAuthorName;
    }

    public void setBookAuthorName(String bookAuthorName) {
        this.bookAuthorName = bookAuthorName;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }



    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthorName=" + bookAuthorName
                + ", bookPrice=" + bookPrice + "]";
    }

    
    
}