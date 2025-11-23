import Exceptions.IsClosedException;
import Exceptions.IsEmpyException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Receipt{
    List<List<String>> receipt = new ArrayList<>();

    public void addLine(BigDecimal pricePerUnit,  int numUnits) throws IsClosedException{
            if (receipt.getLast().contains("C")){
                throw new IsClosedException("Recibo cerrado.");
            }
            if (receipt.isEmpty()) {
                receipt.add(new ArrayList<>());
                receipt.getFirst().add(pricePerUnit.toString());
                receipt.getFirst().add(String.valueOf(numUnits));
            }
            else {
                receipt.add(new ArrayList<>());
                receipt.getLast().add(pricePerUnit.toString());
                receipt.getLast().add(String.valueOf(numUnits));
            }

    }

    public void addTaxes(BigDecimal percent) throws IsClosedException, IsEmpyException {
        if (receipt.isEmpty()) {
            throw new IsEmpyException("Recibo vacío.");
        }
        if (receipt.getLast().contains("C")){
            throw new IsClosedException("Recibo cerrado.");
        }
        int totalAmount = Integer.parseInt(receipt.getLast().getFirst())  * Integer.parseInt(receipt.getLast().getLast());
        int tax = Integer.parseInt(percent.toString()) / 100;
        receipt.getLast().add(String.valueOf(totalAmount * tax));
        receipt.getLast().add("C");
    }

    public BigDecimal getTotal() {
        BigDecimal totalAmount = BigDecimal.ZERO;
        if (receipt.isEmpty()) {
            return totalAmount;
        }
        for (List<String> strings : receipt) {
            BigDecimal pricePerUnit = new BigDecimal(strings.get(0));
            BigDecimal numUnits = new BigDecimal(strings.get(1));
            BigDecimal tax = new BigDecimal(strings.get(2));

            totalAmount = totalAmount.add(pricePerUnit.multiply(numUnits.multiply(tax)));
        }
        return totalAmount;
    }
}
