package rest.api.book.restbookapp.Services;

import java.util.ArrayList;
import java.util.List;

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
}
