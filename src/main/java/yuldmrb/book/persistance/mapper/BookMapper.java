package yuldmrb.book.persistance.mapper;

import org.springframework.jdbc.core.RowMapper;
import yuldmrb.book.persistance.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        return Book.builder()
                .id(rs.getLong("id"))
                .title(rs.getString("title"))
                .author(rs.getString("author"))
                .description(rs.getString("description"))
                .build();
    }
}
