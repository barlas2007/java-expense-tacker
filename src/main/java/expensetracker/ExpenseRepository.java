package expensetracker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExpenseRepository {

    public void addExpense(Expense expense) {

        String sql =
                "INSERT INTO expenses (description, category, amount) VALUES (?, ?, ?)";

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setString(1, expense.getDescription());
            statement.setString(2, expense.getCategory());
            statement.setDouble(3, expense.getAmount());

            int rowsAffected = statement.executeUpdate();

            System.out.println(rowsAffected + " row inserted");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public List<Expense> findAll() {

        List<Expense> expenses = new ArrayList<>();

        String sql =
                "SELECT description, category, amount FROM expenses";

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()
        ) {

            while (resultSet.next()) {

                String description =
                        resultSet.getString("description");

                String category =
                        resultSet.getString("category");

                double amount =
                        resultSet.getDouble("amount");

                Expense expense =
                        new Expense(description, category, amount);

                expenses.add(expense);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return expenses;
    }


    public void updateExpense(
            String description,
            String newCategory,
            double newAmount) {

        String sql =
                "UPDATE expenses " +
                        "SET category = ?, amount = ? " +
                        "WHERE description = ?";

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setString(1, newCategory);
            statement.setDouble(2, newAmount);
            statement.setString(3, description);

            int rowsAffected = statement.executeUpdate();

            System.out.println(rowsAffected + " row updated");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void deleteExpense(String description) {

        String sql =
                "DELETE FROM expenses WHERE description = ?";

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setString(1, description);

            int rowsAffected = statement.executeUpdate();

            System.out.println(rowsAffected + " row deleted");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    private void insertExpense(
            Connection connection,
            Expense expense) throws SQLException {

        String sql =
                "INSERT INTO expenses (description, category, amount) VALUES (?, ?, ?)";

        try (PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, expense.getDescription());
            statement.setString(2, expense.getCategory());
            statement.setDouble(3, expense.getAmount());

            statement.executeUpdate();
        }
    }


    public void addTwoExpenses(
            Expense expense1,
            Expense expense2) {

        try (Connection connection =
                     DatabaseConnection.getConnection()) {

            connection.setAutoCommit(false);

            try {

                insertExpense(connection, expense1);
                insertExpense(connection, expense2);

                connection.commit();

                System.out.println("Transaction committed");

            } catch (SQLException e) {

                connection.rollback();

                System.out.println("Transaction rolled back");
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}