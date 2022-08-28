package Gallery.Book-Gallery.services;

import Gallery.Book-Gallery.domain.Book;
import Gallery.Book-Gallery.repositories.BookRepository;
import org.Book-Gallery.beans.factory.annotation.Autowired;
import org.Book-Gallery.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> listAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
}
