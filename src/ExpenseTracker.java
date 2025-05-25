import java.util.*;

public class ExpenseTracker {
    private final List<Expense> expenses = Collections.synchronizedList(new ArrayList<>());

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public void removeExpense(Expense expense) {
        expenses.remove(expense);
    }

    public void printReport() {
        Map<String, Double> totalExpenses = new HashMap<>();

        synchronized (expenses) {
            for (Expense expense : expenses) {
                totalExpenses.put(expense.getUser(), totalExpenses.getOrDefault(expense.getUser(), 0.0) + expense.getAmount());
            }
        }

        System.out.println("\n=== Expense Report ===");
        totalExpenses.forEach((user, total) -> System.out.println(user + " потратил: " + total + "₸"));
        System.out.println("\nВсего расходов: " + expenses.size());
    }
}
