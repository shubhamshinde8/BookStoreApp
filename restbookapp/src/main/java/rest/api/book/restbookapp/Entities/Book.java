package rest.api.book.restbookapp.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "bookstore")
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;

    private String bookName;

    private int bookPrice;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Author author;

    @Version  // Enables optimistic locking
    private int version;



    public Book(int bookId, String bookName, int bookPrice, Author author) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.author = author;
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



    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice)  {
        this.bookPrice = bookPrice;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "rest.api.book.restbookapp.Entities.Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookPrice=" + bookPrice +
                ", author=" + author +
                ", version=" + version +
                '}';
    }
}
