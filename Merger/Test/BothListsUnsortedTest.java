import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BothListsUnsortedTest {
    private final Merger merger = new Merger();
    private List<Integer> list1, list2;

    @BeforeEach
    public void initList() {
        list1 = Arrays.asList(1,0,2,5,80);
        list2 = Arrays.asList(1,3,2,8,10);
    }

    @Test
    public void mergeSortedExceptionTest() throws IllegalArgumentException{
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    merger.mergeSorted(list1, list2);
                });
        assertEquals("Las listas no cumplen con los requisitos", exception.getMessage());
    }
}
