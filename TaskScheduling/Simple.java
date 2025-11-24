import java.math.BigDecimal;

public class Simple implements Task{
    private final BigDecimal euros;
    private final int days;

    public Simple(BigDecimal euros, int days){
        this.euros = euros;
        this.days = days;
    }
    public BigDecimal costInEuros(){
        return this.euros;
    }
    public int durationInDays(){
        return this.days;
    }
}
