package expensetracker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseTest {

    @Test
    void validExpenseShouldBeCreated() {
        Expense expense = new Expense("Lunch", "Food", 12.50);

        assertEquals("Lunch", expense.getDescription());
        assertEquals("Food", expense.getCategory());
        assertEquals(12.50, expense.getAmount());
    }

    @Test
    void negativeAmountShouldThrowException() {
        assertThrows(
                InvalidExpenseException.class,
                () -> new Expense("Lunch", "Food", -5.00)
        );
    }

    @Test
    void blankDescriptionShouldThrowException() {
        assertThrows(
                InvalidExpenseException.class,
                () -> new Expense("   ", "Food", 10.00)
        );
    }

    @Test
    void blankCategoryShouldThrowException() {
        assertThrows(
                InvalidExpenseException.class,
                () -> new Expense("Lunch", "   ", 10.00)
        );
    }

}
