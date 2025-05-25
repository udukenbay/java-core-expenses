import java.util.ArrayList;
import java.util.List;

public class FamilyExpensesApp {
    public static void main(String[] args) throws InterruptedException {
        ExpenseTracker tracker = new ExpenseTracker();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new User("Family Member_" + i, tracker));
            threads.add(t);
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }

        tracker.printReport();
    }
}