package yuldmrb.book.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yuldmrb.book.model.AuthorSymbolCount;
import yuldmrb.book.persistance.model.Book;
import yuldmrb.book.service.BookService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<Collection<Book>> getAllBooksSortedByTitle() {
        log.info("All books is requested");

        final Collection<Book> result = bookService.getAllBooksSortedByTitle();
        log.info("All books request completed, size={}", result.size());

        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody final Book book) {
        log.info("Adding book is requested: {}", book);

        final Book result = bookService.addBook(book);
        log.info("Book added - request completed, Book: {}", book);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(result);
    }

    @GetMapping("/authors")
    public ResponseEntity<Map<String, List<Book>>> getBooksGroupedByAuthor() {
        log.info("Books grouped by author is requested");

        final Map<String, List<Book>> result = bookService.getBooksGroupedByAuthor();
        log.info("Books grouped by author request completed, size={}", result.size());

        return ResponseEntity.ok(result);
    }

    @GetMapping("/authors/top")
    public ResponseEntity<Collection<AuthorSymbolCount>> getTopAuthorsByCharacter(@RequestParam Character character) {
        log.info("Top authors by character is requested");

        final Collection<AuthorSymbolCount> result = bookService.getTopAuthorsByCharacter(character);
        log.info("Top authors by character request completed, size={}", result.size());

        return ResponseEntity.ok(result);
    }

}
