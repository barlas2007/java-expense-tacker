package expensetracker;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ExpenseTracker tracker = new ExpenseTracker();

        // Load anything saved from an earlier run
        tracker.loadExpenses();

        try {

            Expense gym =
                    new Expense("Gym", "Health", 25.99);

            Expense train =
                    new Expense("Train", "Travel", 8.20);

            Expense lunch =
                    new Expense("Lunch", "Food", 12.50);

            tracker.addExpense(gym);
            tracker.addExpense(train);
            tracker.addExpense(lunch);

        } catch (InvalidExpenseException e) {

            System.out.println(
                    "Could not add expense: " + e.getMessage()
            );
        }

        System.out.println("\nAll expenses:");
        tracker.displayAllExpenses();


        System.out.println(
                "\nCategories: " +
                        tracker.getCategories()
        );

        System.out.println("\nTotals by category:");

        HashMap<String, Double> totals =
                tracker.calculateCategoryTotals();

        for (Map.Entry<String, Double> entry :
                totals.entrySet()) {

            System.out.println(
                    entry.getKey() +
                            ": £" +
                            entry.getValue()
            );
        }

        tracker.saveExpenses();

        System.out.println("enter a expense to search for: ");
        String sExpense = scanner.nextLine();

        tracker.searchExpense(sExpense);

        tracker.sortExpenses();

        System.out.println("total spending : £" + tracker.totalSpending());

        System.out.println("average spending : £" + tracker.averageSpending());

        System.out.println("highest spending : £" + tracker.highestSpending());
    }
}