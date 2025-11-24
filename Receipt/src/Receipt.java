import Exceptions.IsClosedException;
import Exceptions.IsEmptyException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Receipt{
    private final List<List<String>> receipt = new ArrayList<>();

    public void addLine(BigDecimal pricePerUnit,  int numUnits) throws IsClosedException{
        if (!receipt.isEmpty() && receipt.getLast().contains("C")){
            throw new IsClosedException("Recibo cerrado.");
        }
        receipt.add(new ArrayList<>());
        receipt.getLast().add(pricePerUnit.toString());
        receipt.getLast().add(String.valueOf(numUnits));
    }

    public void addTaxes(BigDecimal percent) throws IsClosedException, IsEmptyException {
        if (receipt.isEmpty()) {
            throw new IsEmptyException("Recibo vacío.");
        }
        if (receipt.getLast().contains("C")){
            throw new IsClosedException("Recibo cerrado.");
        }
        receipt.getLast().add(String.valueOf(percent.multiply(new BigDecimal("0.01")).add(BigDecimal.ONE)));
        receipt.getLast().add("C");
    }

    public BigDecimal getTotal() throws IsEmptyException {
        if (receipt.isEmpty()) {
            throw new IsEmptyException("Recibo vacío.");
        }
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (List<String> strings : receipt) {
            BigDecimal pricePerUnit = new BigDecimal(strings.get(0));
            BigDecimal numUnits = new BigDecimal(strings.get(1));
            if (receipt.getLast().contains("C")) {
                BigDecimal tax = new BigDecimal(receipt.getLast().get(2));
                totalAmount = totalAmount.add(pricePerUnit.multiply(numUnits.multiply(tax)));
            } else {
                totalAmount = totalAmount.add(pricePerUnit.multiply(numUnits));
            }
        }
        return totalAmount.setScale(2, RoundingMode.HALF_UP);
    }
}
