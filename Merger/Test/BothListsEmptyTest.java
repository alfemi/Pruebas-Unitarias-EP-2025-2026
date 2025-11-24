import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BothListsEmptyTest {
    private final Merger merger = new Merger();
    private List<Integer> list1, list2, correctResult;

    @BeforeEach
    public void initList() {
        list1 = Collections.emptyList();
        list2 = Collections.emptyList();
        correctResult = Collections.emptyList();
    }

    @Test
    public void mergeSortedExceptionTest() throws IllegalArgumentException{
        assertEquals(correctResult, merger.mergeSorted(list1, list2));
    }
}
