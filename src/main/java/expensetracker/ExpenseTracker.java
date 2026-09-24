package expensetracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ExpenseTracker {

    private final ArrayList<Expense> expenses;

    public ExpenseTracker() {
        expenses = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public void displayAllExpenses() {
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    public HashSet<String> getCategories() {

        HashSet<String> categories = new HashSet<>();

        for (Expense expense : expenses) {
            categories.add(expense.getCategory());
        }

        return categories;
    }

    public HashMap<String, Double> calculateCategoryTotals() {

        HashMap<String, Double> totals = new HashMap<>();

        for (Expense expense : expenses) {

            String category = expense.getCategory();
            double amount = expense.getAmount();

            totals.put(
                    category,
                    totals.getOrDefault(category, 0.0) + amount
            );
        }

        return totals;
    }

    public void searchExpense(String description) {

        expenses.stream()
                .filter(expense ->
                        expense.getDescription()
                                .equalsIgnoreCase(description))
                .findFirst()
                .ifPresent(System.out::println);
    }

    public void sortExpenses() {

        expenses.stream()
                .sorted((e1, e2) ->
                        Double.compare(
                                e1.getAmount(),
                                e2.getAmount()
                        ))
                .forEach(System.out::println);
    }

    public double totalSpending() {
        return expenses.stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    public double averageSpending() {
        return expenses.stream()
                .mapToDouble(Expense::getAmount)
                .average()
                .orElse(0.0);
    }

    public double highestSpending() {
        return expenses.stream()
                .mapToDouble(Expense::getAmount)
                .max()
                .orElse(0.0);
    }
}
