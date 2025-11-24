import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmptyL1Test {
    private final Merger merger = new Merger();
    private List<Integer> list1, list2, correctResult;

    @BeforeEach
    public void initList() {
        list1 = Arrays.asList(1,2,3);
        list2 = Collections.emptyList();
        correctResult = Arrays.asList(1,2,3);
    }

    @Test
    public void mergeSortedExceptionTest() throws IllegalArgumentException{
        assertEquals(correctResult, merger.mergeSorted(list1, list2));
    }
}
