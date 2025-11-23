import Exceptions.AlreadyDefinedException;
import Exceptions.NotDefinedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OneWordDictionaryTest {
    private DictionaryImpl dictionary;

    @BeforeEach
    public void initDictionary() throws AlreadyDefinedException {
        dictionary = new DictionaryImpl();
        dictionary.defineWord("Word", "Definition1");
    }

    @Test
    void defineWordNewWordOneDefinitions() throws NotDefinedException {
        dictionary.defineWord("NewWord", "Definition1");
        assertEquals(dictionary.dictionaryMap.get("NewWord"), dictionary.getDefinitions("NewWord"));
    }
    @Test
    void defineWordNewWordManyDefinitions() throws NotDefinedException {
        dictionary.defineWord("NewWord", "Definition1");
        dictionary.defineWord("NewWord", "Definition2");
        assertEquals(dictionary.dictionaryMap.get("NewWord"), dictionary.getDefinitions("NewWord"));
    }

    @Test
    void defineAlreadyAddedWord() throws NotDefinedException, AlreadyDefinedException{
        dictionary.defineWord("Word", "Definition2");
        dictionary.defineWord("Word", "Definition3");
        assertEquals(dictionary.dictionaryMap.get("Word"), dictionary.getDefinitions("Word"));
    }
}
