import java.util.ArrayList;
import java.util.List;

public class Merger {
    public List<Integer> mergeSorted(List<Integer> list1, List<Integer> list2) throws IllegalArgumentException {
        if (!checkLists(list1, list2)) {
            throw new IllegalArgumentException("Las listas no cumplen con los requisitos");
        } else {
            return sortedLists(list1, list2);
        }
    }

    private boolean checkLists(List<Integer> list1, List<Integer> list2){

        for(int i = 0; i < list1.size() || i < list2.size(); i++){
            for (int x = i + 1; x < list1.size() || x < list2.size(); x++){
                if (i < list1.size() && x < list1.size() && list1.get(i) >= list1.get(x)){
                    return false;
                }
                if (i < list2.size() && x < list2.size() && list2.get(i) >= list2.get(x)){
                    return false;
                }
            }
        }
        return true;
    }

    private List<Integer> sortedLists (List<Integer> list1, List<Integer> list2){
        List<Integer> soretedList = new ArrayList<>();
        int pos1 = 0,pos2 = 0, actPos = 0;
        boolean process = true;

        while (process){
            if (pos2 < list2.size() && list1.get(pos1) <= list2.get(pos2)){
                soretedList.add(actPos, list1.get(pos1));
                if (list1.get(pos1).equals(list2.get(pos2))) {
                    pos2++;
                }
                pos1++;
                actPos++;
            }
            else if (pos2 < list2.size() && list2.get(pos2) < list1.get(pos1)){
                    soretedList.add(actPos, list2.get(pos2));
                    pos2++;
                    actPos++;
            }
            else {
                while (process){
                    soretedList.add(actPos, list1.get(pos1));
                    pos1++;
                    actPos++;
                    if (pos1 == list1.size()){
                        process = false;
                    }
                }
            }
        }
        return soretedList;
    }
}