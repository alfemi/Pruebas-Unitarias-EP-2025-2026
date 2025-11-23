import Exceptions.AlreadyDefinedException;
import Exceptions.NotDefinedException;

import java.util.List;

public interface Dictionary {
    void defineWord(String word, String definition) throws AlreadyDefinedException;
    List<String> getDefinitions(String word) throws NotDefinedException;
}