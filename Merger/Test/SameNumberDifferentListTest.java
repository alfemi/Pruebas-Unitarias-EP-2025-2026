import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SameNumberDifferentListTest {
    private final Merger merger = new Merger();
    private List<Integer> list1, list2, correctResult;

    @BeforeEach
    public void initList() {
        list1 = Arrays.asList(1,8,20,50,80);
        list2 = Arrays.asList(1,3,6,8,10);
        correctResult = Arrays.asList(1,3,6,8,10,20,50,80);
    }

    @Test
    public void mergeSortedExceptionTest() throws IllegalArgumentException{
        assertEquals(correctResult, merger.mergeSorted(list1, list2));
    }
}
