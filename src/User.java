import java.util.concurrent.ThreadLocalRandom;

public class User implements Runnable {

    private final String name;
    private final ExpenseTracker tracker;
    private final String[] categories = {"Products", "Transport", "Cafe", "Pharmacy", "Entertainment"};

    public User (String name, ExpenseTracker tracker) {
        this.name = name;
        this.tracker = tracker;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(100, 300));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String category = categories[ThreadLocalRandom.current().nextInt(categories.length)];
            double amount = ThreadLocalRandom.current().nextDouble(1000, 10000);

            Expense expense = new Expense(name, category, Math.round(amount * 100.0) / 100.0);
            tracker.addExpense(expense);
            System.out.println("Added expense: " + expense);
        }
    }
}
