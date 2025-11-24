import Exceptions.IsClosedException;
import Exceptions.IsEmptyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddTaxTest {
    Receipt receipt = new Receipt();

    @BeforeEach
    void initReceipt() {
        receipt.addLine(new BigDecimal("24.32"), 32);
    }

    @Test
    void addTaxOneLineTest() throws IsEmptyException {
        receipt.addTaxes(new BigDecimal("12.332"));
        assertEquals(new BigDecimal("874.21"), receipt.getTotal());
    }

    @Test
    void addTaxMoreLinesTest() throws IsEmptyException {
        receipt.addLine(new BigDecimal("12.39"), 11);
        receipt.addTaxes(new BigDecimal("46.3565"));

        assertEquals(new BigDecimal("1338.47"), receipt.getTotal());
    }

    @Test
    void isEmptyExceptionTest() throws IsClosedException, IsEmptyException {
        receipt = new Receipt();
        Throwable exception = assertThrows(IsEmptyException.class,
                () -> {
                    receipt.addTaxes(new BigDecimal("23.1349"));
                });
        assertEquals("Recibo vacío.", exception.getMessage());
    }

    @Test
    void isClosedExceptionTest() throws IsClosedException, IsEmptyException {
        receipt.addTaxes(new BigDecimal("33.4"));
        Throwable exception = assertThrows(IsClosedException.class,
                () -> {
                    receipt.addTaxes(new BigDecimal("43.1349"));
                });
        assertEquals("Recibo cerrado.", exception.getMessage());
    }
}
