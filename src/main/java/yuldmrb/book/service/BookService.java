package yuldmrb.book.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import yuldmrb.book.model.AuthorSymbolCount;
import yuldmrb.book.persistance.model.Book;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Сервис для работы с книгами
 */
@Validated
public interface BookService {

    /**
     * Получить все книги, отсортированные по названию в обратном алфавитном порядке
     *
     * @return список книг
     */
    Collection<Book> getAllBooksSortedByTitle();

    /**
     * Добавить книгу
     *
     * @param book книга
     * @return добавленная книга
     */
    Book addBook(@Valid @NotNull final Book book);

    /**
     * Получает все книги, сгруппированные по автору.
     *
     * @return книги, сгруппированные по автору
     */
    Map<String, List<Book>> getBooksGroupedByAuthor();

    /**
     * Получить топ авторов по количеству символов в имени
     * @param character символ
     * @return список авторов
     */
    Collection<AuthorSymbolCount> getTopAuthorsByCharacter(final Character character);

}
