package diplomski_rad.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import diplomski_rad.models.BookModel;
import diplomski_rad.repositories.BookRepository;

@RestController
@CrossOrigin
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Endpoint koji vraća sve knjige sa autorom, izdavačem i žanrovima
    @GetMapping("api/books")
    public List<BookModel> getAllBooks() {
        // FetchType.EAGER u BookModel za author, publisher i genres
        // Jackson sa @JsonManagedReference / @JsonBackReference će omogućiti serijalizaciju
        return bookRepository.findAll();
    }
}
