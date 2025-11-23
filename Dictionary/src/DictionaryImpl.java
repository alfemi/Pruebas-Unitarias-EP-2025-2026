import Exceptions.AlreadyDefinedException;
import Exceptions.NotDefinedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DictionaryImpl implements Dictionary {
    Map<String, List<String>> dictionaryMap = new HashMap<>();

    @Override
    public void defineWord(String word, String definition) throws AlreadyDefinedException {
        if (dictionaryMap.containsKey(word) && dictionaryMap.get(word).contains(definition)) {
            throw new AlreadyDefinedException("Ya incluida en el diccionario");
        } else {
            if (dictionaryMap.containsKey(word)) {
                dictionaryMap.get(word).add(definition);
            } else {
                dictionaryMap.put(word, new ArrayList<>());
                dictionaryMap.get(word).add(definition);
            }
        }
    }

    @Override
    public List<String> getDefinitions(String word) throws NotDefinedException {
        if(dictionaryMap.containsKey(word)){
            return dictionaryMap.get(word);
        } else  {
            throw new NotDefinedException("No incluida en el diccionario");
        }
    }
}