package expensetracker;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ExpenseTracker {

    private ArrayList<Expense> expenses;

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

            if (totals.containsKey(category)) {

                double currentTotal = totals.get(category);

                totals.put(category, currentTotal + amount);

            } else {

                totals.put(category, amount);
            }
        }

        return totals;
    }

    public void saveExpenses() {

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter("expenses.txt"))) {

            for (Expense expense : expenses) {

                writer.write(
                        expense.getDescription() + "," +
                                expense.getCategory() + "," +
                                expense.getAmount()
                );

                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println(
                    "Could not save expenses: " + e.getMessage()
            );
        }
    }

    public void loadExpenses() {

        expenses.clear();

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader("expenses.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {

                try {

                    String[] parts = line.split(",");

                    String description = parts[0];
                    String category = parts[1];
                    double amount =
                            Double.parseDouble(parts[2]);

                    Expense expense =
                            new Expense(
                                    description,
                                    category,
                                    amount
                            );

                    expenses.add(expense);

                } catch (
                        NumberFormatException |
                        ArrayIndexOutOfBoundsException |
                        InvalidExpenseException e
                ) {

                    System.out.println(
                            "Skipping invalid line: " + line
                    );
                }
            }

        } catch (FileNotFoundException e) {

            System.out.println(
                    "No saved expenses found. Starting empty."
            );

        } catch (IOException e) {

            System.out.println(
                    "Could not load expenses: " + e.getMessage()
            );
        }
    }

    public void searchExpense(String sExpense) {
        expenses.stream()
                .filter(expense -> expense.getDescription().equalsIgnoreCase(sExpense))
                .findFirst()
                .ifPresent(System.out::println);

    }

    public void sortExpenses() {
        expenses.stream()
                .sorted((e1, e2) -> Double.compare(e1.getAmount(), e2.getAmount()))
                .forEach(System.out::println);
    }

    public double totalSpending() {
        return expenses.stream()
                .mapToDouble(Expense -> Expense.getAmount())
                .sum();
    }

    public double averageSpending() {
        return expenses.stream()
                .mapToDouble(Expense -> Expense.getAmount())
                .average()
                .orElse(0.0);

    }

    public double highestSpending() {
        return expenses.stream()
                .mapToDouble(Expense -> Expense.getAmount())
                .max()
                .orElse(0.0);
    }

}
