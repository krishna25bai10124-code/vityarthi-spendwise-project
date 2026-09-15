import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
public class ExpenseManager {
    ArrayList<Expense> expenses = new ArrayList<>();
    String fileName = "data/expenses.txt";
    public void addExpense(Expense expense) {
        for (Expense e : expenses) {
            if (e.getId() == expense.getId()) {
                System.out.println("Expense ID already exists.");
                return;
            }
        }

        expenses.add(expense);
        saveExpenses();
        System.out.println("Expense added successfully!");
    }
    public void viewExpenses() {
        if (expenses.size() == 0) {
            System.out.println("No expenses found.");
            return;
        }

        System.out.println();
        System.out.printf("%-5s %-10s %-15s %-25s %-12s%n",
                "ID", "Amount", "Category", "Description", "Date");

        for (Expense expense : expenses) {
            expense.displayExpense();
        }
    }
    public void searchByCategory(String category) {
        boolean found = false;

        for (Expense expense : expenses) {
            if (expense.getCategory().equalsIgnoreCase(category)) {

                if (!found) {
                    System.out.println();
                    System.out.println("Expenses in category: " + category);
                    System.out.printf("%-5s %-10s %-15s %-25s %-12s%n",
                            "ID", "Amount", "Category", "Description", "Date");
                }

                expense.displayExpense();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No expenses found in this category.");
        }
    }
    public double calculateTotal() {
        double total = 0;

        for (Expense expense : expenses) {
            total = total + expense.getAmount();
        }

        return total;
    }
    public void deleteExpense(int id) {
        Iterator<Expense> iterator = expenses.iterator();

        while (iterator.hasNext()) {
            Expense expense = iterator.next();

            if (expense.getId() == id) {
                iterator.remove();
                saveExpenses();
                System.out.println("Expense deleted successfully!");
                return;
            }
        }

        System.out.println("Expense with ID " + id + " not found.");
    }
    private void saveExpenses() {
        try {
            File directory = new File("data");

            if (!directory.exists()) {
                directory.mkdir();
            }

            FileWriter writer = new FileWriter(fileName);

            for (Expense expense : expenses) {
                writer.write(
                        expense.getId() + "|" +
                        expense.getAmount() + "|" +
                        expense.getCategory() + "|" +
                        expense.getDescription() + "|" +
                        expense.getDate() + "\n"
                );
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving expenses.");
        }
    }
    public void loadExpenses() {
        File file = new File(fileName);

        if (!file.exists()) {
            return;
        }
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader(file)
            );

            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");

                if (data.length == 5) {
                    int id = Integer.parseInt(data[0]);
                    double amount = Double.parseDouble(data[1]);
                    String category = data[2];
                    String description = data[3];
                    String date = data[4];

                    Expense expense = new Expense(
                            id,
                            amount,
                            category,
                            description,
                            date
                    );

                    expenses.add(expense);
                }
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error loading expenses.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid data in expense file.");
        }
    }
}
