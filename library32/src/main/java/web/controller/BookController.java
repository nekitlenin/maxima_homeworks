package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.Author;
import web.model.Genre;
import web.service.AuthorServiceEntity;
import web.service.BookServiceEntity;
import web.service.GenreServiceEntity;

import java.util.Optional;

/**
 * Project: Pikcha
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 11.05.2023 11:29 |
 * Created with IntelliJ IDEA
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookServiceEntity bookService;
    private final GenreServiceEntity genreService;
    private final AuthorServiceEntity authorService;

    @GetMapping("/findAllBooks")
    public ResponseEntity<String> findAll() {
        return ResponseEntity.ok(bookService.findAll().toString());
    }

    @GetMapping("/findBooksById/{id}")
    public ResponseEntity<String> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(bookService.findById(id).toString());
    }
    @GetMapping("/findBooksByGenre/{genreId}")
    public ResponseEntity<String> findByGenre(@PathVariable("genreId") Long genreId) {
        Optional<Genre> genre = genreService.findById(genreId);
        return ResponseEntity.ok(bookService.findByGenre(genre).toString());
    }

    @GetMapping("/findBooksByAuthor/{authorId}")
    public ResponseEntity<String> findByAuthor(@PathVariable("authorId") Long authorId) {
        Optional<Author> author = authorService.findById(authorId);
        return ResponseEntity.ok(bookService.findByAuthor(author).toString());
    }

    @GetMapping("/findTitleAndAuthorNameByBookId/{bookId}")
    public ResponseEntity<String> findAuthorNameAndBooksByAuthorId(@PathVariable("bookId") Long bookId) {
//        Optional<Author> author = authorService.findById(authorId);
        return ResponseEntity.ok(bookService.findById(bookId).toString());
    }
}
