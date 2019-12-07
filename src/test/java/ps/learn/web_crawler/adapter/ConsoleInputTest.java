package ps.learn.web_crawler.adapter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ps.learn.web_crawler.domain.SearchTerm;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsoleInputTest {
    private ConsoleInput consoleInput;


    @BeforeEach
    void setUp() {
        consoleInput = new ConsoleInput();
    }

    @Test
    void givenSignleWordInput_whenReadingSearchTerm_shouldReturnSearchTerm() {
        // Given
        String[] args = new String[]{
                "hello"
        };

        // When
        final SearchTerm searchTerm = consoleInput.readSearchTerm(args);

        // Then
        assertEquals("hello", searchTerm.getValue());
    }

    @Test
    void givenInputWithManyArgs_whenReadingSearchTerm_shouldFirstArgument() {
        // Given
        String[] args = new String[]{
                "hello", "world", "abc"
        };

        // When
        final SearchTerm searchTerm = consoleInput.readSearchTerm(args);

        // Then
        assertEquals("hello", searchTerm.getValue());
    }

    @Test
    void givenEmptyInput_whenReadingSearchTerm_shouldThrowException() {
        // Given
        String[] args = new String[]{};

        // When && Then
        Assertions.assertThrows(InvalidInputException.class,
                () -> consoleInput.readSearchTerm(args));
    }

    @Test
    void givenInputWithEmptyString_whenReadingSearchTerm_shouldThrowException() {
        // Given
        String[] args = new String[]{""};

        // When && Then
        Assertions.assertThrows(InvalidInputException.class,
                () -> consoleInput.readSearchTerm(args));
    }
}