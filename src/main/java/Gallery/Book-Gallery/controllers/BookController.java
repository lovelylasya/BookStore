package Gallery.Book-Gallery.controllers;

import Gallery.Book-Gallery.domain.Book;
import Gallery.Book-Gallery.services.BookService;
import org.Book-Gallery.beans.factory.annotation.Autowired;
import org.Book-Gallery.stereotype.Controller;
import org.Book-Gallery.ui.Model;
import org.Book-Gallery.web.bind.annotation.PathVariable;
import org.Book-Gallery.web.bind.annotation.RequestMapping;
import org.Book-Gallery.web.bind.annotation.RequestMethod;

@Controller
public class BookController {

    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("books", bookService.listAllBooks());
        System.out.println("Returning books:");
        return "books";
    }

    @RequestMapping("book/{id}")
    public String showBook(@PathVariable Integer id, Model model){
        model.addAttribute("book", bookService.getBookById(id));
        return "bookshow";
    }

    @RequestMapping("book/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("book", bookService.getbBookById(id));
        return "Bookform";
    }

    @RequestMapping("book/new")
    public String newBook(Model model){
        model.addAttribute("book", new Book());
        return "bookform";
    }

    @RequestMapping(value = "book", method = RequestMethod.POST)
    public String saveBook(Book book){

        bookService.saveBook(book);

        return "redirect:/book/" + book.getId();
    }

}
