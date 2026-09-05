package expensetracker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseTrackerTest {

    @Test
    void totalSpendingShouldBeCalculatedCorrectly() {
        ExpenseTracker tracker = new ExpenseTracker();

        tracker.addExpense(new Expense("Lunch", "Food", 10.00));
        tracker.addExpense(new Expense("Bus", "Travel", 5.00));

        assertEquals(15.00, tracker.totalSpending());
    }

    @Test
    void averageSpendingShouldBeCalculatedCorrectly() {
        ExpenseTracker tracker = new ExpenseTracker();

        tracker.addExpense(new Expense("Lunch", "Food", 10.00));
        tracker.addExpense(new Expense("Bus", "Travel", 20.00));

        assertEquals(15.00, tracker.averageSpending());
    }

    @Test
    void highestSpendingShouldBeCalculatedCorrectly() {
        ExpenseTracker tracker = new ExpenseTracker();

        tracker.addExpense(new Expense("Lunch", "Food", 10.00));
        tracker.addExpense(new Expense("Bus", "Travel", 20.00));
        tracker.addExpense(new Expense("Cinema", "Entertainment", 15.00));

        assertEquals(20.00, tracker.highestSpending());
    }

    @Test
    void emptyTrackerShouldReturnZeroForTotal() {
        ExpenseTracker tracker = new ExpenseTracker();

        assertEquals(0.00, tracker.totalSpending());
    }

    @Test
    void emptyTrackerShouldReturnZeroForAverage() {
        ExpenseTracker tracker = new ExpenseTracker();

        assertEquals(0.00, tracker.averageSpending());
    }

    @Test
    void emptyTrackerShouldReturnZeroForHighest() {
        ExpenseTracker tracker = new ExpenseTracker();

        assertEquals(0.00, tracker.highestSpending());
    }
}