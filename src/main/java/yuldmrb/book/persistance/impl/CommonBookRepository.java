package yuldmrb.book.persistance.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import yuldmrb.book.persistance.BookRepository;
import yuldmrb.book.persistance.mapper.BookMapper;
import yuldmrb.book.persistance.model.Book;

import java.util.Collection;


@Slf4j
@Repository
@RequiredArgsConstructor
public class CommonBookRepository implements BookRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Collection<Book> findAllBooksSortedByTitleDesc() {
        final String sql = "SELECT * FROM book ORDER BY title DESC";

        return jdbcTemplate.query(sql, new BookMapper());
    }


    @Override
    public Book addBook(Book book) {
        final String sql = "INSERT INTO book (id, title, author, description) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, book.id(), book.title(), book.author(), book.description());

        return book;
    }
}
