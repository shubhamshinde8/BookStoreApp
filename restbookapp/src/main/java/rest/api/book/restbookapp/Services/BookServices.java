package rest.api.book.restbookapp.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import rest.api.book.restbookapp.Entities.Book;

@Service
public class BookServices {
    
    public static List<Book> list=new ArrayList<>();
    static{
        list.add(new Book(12,"Mrutunjay","Shivaji savant",546));
        list.add(new Book(13,"Castesism in india","Dr.Babasaheb Ambedakar",453));
        list.add(new Book(156,"Buddhha and His Dhamma","Dr.Babasaheb Ambedakar",946));
    }
    
    public List<Book> getAllBooks(){
        return list;
    }

    public Book getBook(int id){
        Book book=null;
        book=list.stream().filter(e->e.getBookId()==id).findFirst().get();
        return book;
    }

    public Book sendBook(Book book){
        list.add(book);
        return book;
    }

    public void deleteBook(int id){
        list=list.stream().filter(e->e.getBookId()!=id).collect(Collectors.toList());
    }

    public void updateBook(Book book,int id){
        list.stream().map(b->{
            if(b.getBookId()==id){
                b.setBookName(book.getBookName());
                b.setBookAuthorName(book.getBookAuthorName());
                b.setBookPrice(book.getBookPrice() );
            }
            return b;
        }).collect(Collectors.toList());
    }
}
