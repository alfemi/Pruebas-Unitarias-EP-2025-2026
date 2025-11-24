import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmptyL2Test {
    private final Merger merger = new Merger();
    private List<Integer> list1, list2, correctResult;

    @BeforeEach
    public void initList() {
        list1 = Collections.emptyList();
        list2 = Arrays.asList(1,2,3);
        correctResult = Arrays.asList(1,2,3);
    }

    @Test
    public void mergeSortedExceptionTest() throws IllegalArgumentException{
        assertEquals(correctResult, merger.mergeSorted(list1, list2));
    }
}
