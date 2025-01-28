package rest.api.book.restbookapp.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import rest.api.book.restbookapp.Entities.Book;


@Repository
public interface BookRepository extends CrudRepository<Book,Integer> {

     Book findByBookId(int bookId);


}
