package rest.api.book.restbookapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import rest.api.book.restbookapp.Entities.Book;
import rest.api.book.restbookapp.Services.BookServices;


@RestController
public class BookController {
    
    @Autowired
    public BookServices bookServices;

    @GetMapping("/books")
    public List<Book> getBooks(){
        
        List<Book> book=bookServices.getAllBooks();
        return book;
    }


    @GetMapping("/books/{id}")
    public Book getbook(@PathVariable("id") int id) {
        return bookServices.getBook(id);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        Book b=this.bookServices.sendBook(book);
        return b;
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable("id") int id){
        this.bookServices.deleteBook(id);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book book,@PathVariable("id") int id){
        this.bookServices.updateBook(book,id);
        return book;
    }
}
