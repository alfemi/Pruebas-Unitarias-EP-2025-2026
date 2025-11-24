import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class Composed implements Task {

    private final List<Task> subtasks = new ArrayList<>();

    public void addSubtask(Task subtask) {
        subtasks.add(subtask);
    }

    public BigDecimal costInEuros() {
        BigDecimal total = BigDecimal.ZERO;

        for (Task t : subtasks) {
            total = total.add(t.costInEuros());
        }

        return total;
    }
}