package rest.api.book.restbookapp.Controller;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.CacheRetrieveMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Book>> getBooks(){
        List<Book> book=bookServices.getAllBooks();
        if (book.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }


    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getbook(@PathVariable("id") int id) {
        Book book=bookServices.getBookById(id);
        if(book==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book b=this.bookServices.addBook(book);
        if(b==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable("id") int id){
        this.bookServices.deleteBook(id);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book book,@PathVariable("id") int id){
        this.bookServices.updateBook(id,book);
        return book;
    }

    @GetMapping("books/cnt")
    public long checkCnt(){
       return this.bookServices.cnt();
    }

}
