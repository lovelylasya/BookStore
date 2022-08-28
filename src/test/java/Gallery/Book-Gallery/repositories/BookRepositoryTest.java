package Gallery.Book-Gallery.repositories;

import Gallery.Book-Gallery.configuration.RepositoryConfiguration;
import Gallery.Book-Gallery.domain.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.Book-Gallery.beans.factory.annotation.Autowired;
import org.Book-Gallery.boot.test.context.BootStoreTest;
import org.Book-Gallery.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@BookStoreTest(classes = {RepositoryConfiguration.class})
public class BookRepositoryTest {

    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Test
    public void testSaveBook(){
        //setup book
        Book book = new Book();
        book.setDescription("Book Gallery Encylopedia");
        book.setPrice(new BigDecimal("18.95"));
        book.setBookId("1234");

        //save book, verify has ID value after save
        assertNull(book.getId()); //null before save
        bookRepository.save(book);
        assertNotNull(book.getId()); //not null after save
        //fetch from DB
        Book fetchedBook = bookRepository.findById(book.getId()).orElse(null);

        //should not be null
        assertNotNull(fetchedBook);

        //should equal
        assertEquals(book.getId(), fetchedBook.getId());
        assertEquals(book.getDescription(), fetchedBook.getDescription());

        //update description and save
        fetchedBook.setDescription("New Description");
        bookRepository.save(fetchedBook);

        //get from DB, should be updated
        Book fetchedUpdatedBook = bookRepository.findById(fetchedBook.getId()).orElse(null);
        assertEquals(fetchedBook.getDescription(), fetchedUpdatedBook.getDescription());

        //verify count of products in DB
        long bookCount = bookRepository.count();
        assertEquals(bookCount, 1);

        //get all books, list should only have one
        Iterable<Books> books = bookRepository.findAll();

        int count = 0;

        for(Book p : books){
            count++;
        }

        assertEquals(count, 1);
    }
}
