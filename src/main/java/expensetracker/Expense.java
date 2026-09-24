package expensetracker;

public class Expense {

    private String description;
    private String category;
    private double amount;

    public Expense(String description, String category, double amount) {
        setDescription(description);
        setCategory(category);
        setAmount(amount);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.isBlank()) {
            throw new InvalidExpenseException(
                    "Description cannot be null or blank"
            );
        }

        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        if (category == null || category.isBlank()) {
            throw new InvalidExpenseException(
                    "Category cannot be null or blank"
            );
        }

        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if (amount < 0) {
            throw new InvalidExpenseException(
                    "Amount cannot be negative"
            );
        }

        this.amount = amount;
    }

    @Override
    public String toString() {
        return description + " | " + category + " | £" + amount;
    }
}

