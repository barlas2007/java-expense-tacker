package expensetracker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ExpenseRepository expenseRepository =
                new ExpenseRepository();

        ExpenseTracker tracker =
                new ExpenseTracker();

        List<Expense> databaseExpenses =
                expenseRepository.findAll();

        for (Expense expense : databaseExpenses) {
            tracker.addExpense(expense);
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
                    entry.getKey()
                            + ": £"
                            + entry.getValue()
            );
        }

        System.out.println(
                "\nEnter an expense to search for:"
        );

        String searchExpense =
                scanner.nextLine();

        tracker.searchExpense(searchExpense);

        System.out.println("\nExpenses sorted by amount:");
        tracker.sortExpenses();

        System.out.println(
                "\nTotal spending: £"
                        + tracker.totalSpending()
        );

        System.out.println(
                "Average spending: £"
                        + tracker.averageSpending()
        );

        System.out.println(
                "Highest spending: £"
                        + tracker.highestSpending()
        );

        scanner.close();
    }
}
