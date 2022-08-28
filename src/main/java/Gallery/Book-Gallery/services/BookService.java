package Gallery.Book-Gallery.services;


import Gallery.Book-Gallery.domain.Book;

public interface BookService {
    Iterable<Book> listAllBooks();

    Book getBookById(Integer id);

    Book saveBook(Book book);
}
