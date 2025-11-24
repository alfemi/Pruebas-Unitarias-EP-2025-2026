import Exceptions.NotDefinedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class EmptyDictionaryTest {
    private DictionaryImpl dictionary;

    @BeforeEach
    void initDictionary() {
        dictionary = new DictionaryImpl();
    }

    @Test
    void addWord() {
        dictionary.dictionaryMap.put("Word1", new ArrayList<>());
        assertTrue(dictionary.dictionaryMap.containsKey("Word1"));
    }

    @Test
    void addFirstDefinition() throws NotDefinedException {
        dictionary.dictionaryMap.put("Word1", new ArrayList<>());
        dictionary.dictionaryMap.get("Word1").add("Definition1");
        assertEquals("Definition1", dictionary.getDefinitions("Word1").getFirst());
    }

    @Test
    void removeWord () {
        dictionary.dictionaryMap.put("Word1", new ArrayList<>());
        dictionary.dictionaryMap.remove("Word1");
        assertFalse(dictionary.dictionaryMap.containsKey("Word1"));
    }

    @Test
    void removeFirstDefinition () {
        dictionary.dictionaryMap.put("Word1", new ArrayList<>());
        dictionary.dictionaryMap.get("Word1").add("Definition1");
        dictionary.dictionaryMap.get("Word1").remove("Definition1");
        assertFalse(dictionary.dictionaryMap.get("Word1").contains("Definition1"));
    }

    @Test
    void removeNDefinition () {
        dictionary.dictionaryMap.put("Word1", new ArrayList<>());
        dictionary.dictionaryMap.get("Word1").add("Definition1");
        dictionary.dictionaryMap.get("Word1").add("Definition2");
        dictionary.dictionaryMap.get("Word1").remove("Definition2");
        assertFalse(dictionary.dictionaryMap.get("Word1").contains("Definition2"));
    }

    @Test
    void getEmptyDefinition() throws NotDefinedException{
        dictionary.defineWord("Word", "");
        assertEquals("", dictionary.getDefinitions("Word").getFirst());
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

}

