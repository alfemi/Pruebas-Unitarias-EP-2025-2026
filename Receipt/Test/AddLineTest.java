import Exceptions.IsClosedException;
import Exceptions.IsEmptyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddLineTest {
    Receipt receipt = new Receipt();

    @BeforeEach
    void initReceipt() {
        receipt.addLine(new BigDecimal("84.99"), 32);
    }

    @Test
    void addFirstLineTest() throws IsEmptyException {
        assertEquals(new BigDecimal("2719.68"), receipt.getTotal());
    }

    @Test
    void addMoreLinesTest() throws IsEmptyException{
        receipt.addLine(new BigDecimal("12.39"), 11);

        assertEquals(new BigDecimal("2855.97"), receipt.getTotal());
    }

    @Test
    void isEmptyExceptionTest() throws IsClosedException, IsEmptyException {
        receipt.addTaxes(new BigDecimal("33.4"));
        Throwable exception = assertThrows(IsClosedException.class,
                () -> {
                    receipt.addLine(new BigDecimal("243.14"), 13);
                });
        assertEquals("Recibo cerrado.", exception.getMessage());
    }
}
