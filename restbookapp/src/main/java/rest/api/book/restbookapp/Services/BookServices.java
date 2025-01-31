package rest.api.book.restbookapp.Services;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import rest.api.book.restbookapp.Entities.Book;
import rest.api.book.restbookapp.Repository.BookRepository;

import java.util.List;

@Service
public class BookServices {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
     List<Book> list= (List<Book>) this.bookRepository.findAll();
     return list;
    }

    public Book getBookById(int id){

        Book b=null;
        try {
            b = this.bookRepository.findByBookId(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return b;
    }

    public Book addBook(Book b){
        Book book=this.bookRepository.save(b);
        return book;
    }

    public void deleteBook(int id){
        this.bookRepository.deleteById(id);
    }

//    public void updateBook(Book book,int id){
//        book.setBookId(id);
//        this.bookRepository.save(book);
//    }

    @Transactional
    public void updateBook(int bookId, Book updatedBookData) {
        try {
            Book book = bookRepository.findById(bookId)
                    .orElseThrow(() -> new RuntimeException("Book not found"));

            book.setBookName(updatedBookData.getBookName());
            book.setBookPrice(updatedBookData.getBookPrice());
            book.setAuthor(updatedBookData.getAuthor());

            bookRepository.save(book);
        } catch (ObjectOptimisticLockingFailureException e) {
            System.out.println("Optimistic Locking Failure: " + e.getMessage());
            throw new RuntimeException("Another user has modified this book. Please retry.");
        }
    }

    public long cnt(){
        return this.bookRepository.count();
    }






































    

    
    // public static List<Book> list=new ArrayList<>();
    // static{
    //     list.add(new Book(12,"Mrutunjay","Shivaji savant",546));
    //     list.add(new Book(13,"Castesism in india","Dr.Babasaheb Ambedakar",453));
    //     list.add(new Book(156,"Buddhha and His Dhamma","Dr.Babasaheb Ambedakar",946));
    // }
    
    // public List<Book> getAllBooks(){
    //     return list;
    // }

    // public Book getBook(int id){
    //     Book book=null;
    //     book=list.stream().filter(e->e.getBookId()==id).findFirst().get();
    //     return book;
    // }

    // public Book sendBook(Book book){
    //     list.add(book);
    //     return book;
    // }

    // public void deleteBook(int id){
    //     list=list.stream().filter(e->e.getBookId()!=id).collect(Collectors.toList());
    // }

    // public void updateBook(Book book,int id){
    //     list.stream().map(b->{
    //         if(b.getBookId()==id){
    //             b.setBookName(book.getBookName());
    //             b.setBookAuthorName(book.getBookAuthorName());
    //             b.setBookPrice(book.getBookPrice() );
    //         }
    //         return b;
    //     }).collect(Collectors.toList());
    // }
}
