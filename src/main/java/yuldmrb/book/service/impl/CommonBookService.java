package yuldmrb.book.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import yuldmrb.book.model.AuthorSymbolCount;
import yuldmrb.book.persistance.BookRepository;
import yuldmrb.book.persistance.model.Book;
import yuldmrb.book.service.BookService;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommonBookService implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Collection<Book> getAllBooksSortedByTitle() {
        return bookRepository.findAllBooksSortedByTitleDesc();
    }

    @Override
    public Book addBook(final Book book) {
        log.info("Adding book: {}", book);
        return bookRepository.addBook(book);
    }

    @Override
    public Map<String, List<Book>> getBooksGroupedByAuthor() {
        final Collection<Book> books = bookRepository.findAllBooksSortedByTitleDesc();

        return books.stream().collect(Collectors.groupingBy(Book::author));
    }

    @Override
    public Collection<AuthorSymbolCount> getTopAuthorsByCharacter(final Character character) {
        char lowerCaseChar = Character.toLowerCase(character);
        final Map<String, Integer> authorSymbolCount = new HashMap<>();

        final Collection<Book> books = bookRepository.findAllBooksSortedByTitleDesc();

        books.forEach(book -> {
            String title = book.title().toLowerCase();
            int count = (int) title.chars().filter(ch -> ch == lowerCaseChar).count();

            if (count > 0) {
                authorSymbolCount.put(book.author(), authorSymbolCount.getOrDefault(book.author(), 0) + count);
            }
        });

        return authorSymbolCount.entrySet().stream()
                .limit(10)
                .map(entry -> new AuthorSymbolCount(entry.getKey(), entry.getValue()))
                .sorted(Comparator.comparing(AuthorSymbolCount::symbolCount).reversed())
                .toList();
    }
}
