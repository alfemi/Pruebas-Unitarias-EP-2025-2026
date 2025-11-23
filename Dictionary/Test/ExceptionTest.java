import Exceptions.AlreadyDefinedException;
import Exceptions.NotDefinedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionTest {
    private DictionaryImpl dictionary;

    @BeforeEach
    void initDictionary() {
        dictionary = new DictionaryImpl();
    }

    @Test
    void NotDefinedException() {
        Throwable exception = assertThrows(NotDefinedException.class,
                () -> {
                    dictionary.getDefinitions("Def");
                });
        assertEquals("No incluida en el diccionario", exception.getMessage());
    }

    @Test
    void AlreadyDefinedException() {
        dictionary.dictionaryMap.put("Word", new ArrayList<>());
        dictionary.dictionaryMap.get("Word").add("Def");
        Throwable exception = assertThrows(AlreadyDefinedException.class,
                () -> {
                    dictionary.defineWord("Word","Def");
                });
        assertEquals("Ya incluida en el diccionario", exception.getMessage());
    }


}
