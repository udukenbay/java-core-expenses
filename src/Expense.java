import java.time.LocalDateTime;

public class Expense {
    private final String user;
    private final String category;
    private final double amount;
    private final LocalDateTime timestamp;

    public Expense(String user, String category, double amount) {
        this.user = user;
        this.category = category;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public String getUser() {
        return user;
    }

    public double getAmount() {
        return amount;
    }

    public String toString() {
        return timestamp + " | " + user + " | " + category + " | " + amount + "₸";
    }
}
