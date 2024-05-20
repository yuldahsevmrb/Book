package yuldmrb.book.model;

import lombok.Builder;

/**
 * Запись, содержащая информацию об авторе и количестве символов в его имени
 */

@Builder
public record AuthorSymbolCount(

        String author,
        Integer symbolCount) {
}
