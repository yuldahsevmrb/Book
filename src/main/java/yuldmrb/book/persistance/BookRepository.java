package yuldmrb.book.persistance;

import org.springframework.validation.annotation.Validated;
import yuldmrb.book.persistance.model.Book;

import java.util.Collection;

/**
 * Репозиторий для работы с книгами
 */
@Validated
public interface BookRepository {

    /**
     * Получить все книги, отсортированные по названию в обратном алфавитном порядке
     *
     * @return список книг
     */
    Collection<Book> findAllBooksSortedByTitleDesc();

    /**
     * Добавить книгу
     *
     * @param book книга
     * @return добавленная книга
     */
    Book addBook(Book book);
}
