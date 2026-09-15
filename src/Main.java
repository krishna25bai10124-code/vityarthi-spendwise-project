import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();
        manager.loadExpenses();
        int choice;
        do {
            System.out.println();
            System.out.println("PERSONAL EXPENSE TRACKER");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Search by Category");
            System.out.println("4. Calculate Total Expenses");
            System.out.println("5. Delete Expense");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {

                    case 1:
                        System.out.print("Enter expense ID: ");
                        int id = Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter amount: ");
                        double amount = Double.parseDouble(scanner.nextLine());

                        if (amount <= 0) {
                            throw new IllegalArgumentException("Amount must be greater than 0.");
                        }

                        System.out.print("Enter category: ");
                        String category = scanner.nextLine();

                        System.out.print("Enter description: ");
                        String description = scanner.nextLine();

                        System.out.print("Enter date: ");
                        String date = scanner.nextLine();

                        Expense expense = new Expense(id, amount, category, description, date);
                        manager.addExpense(expense);
                        break;

                    case 2:
                        manager.viewExpenses();
                        break;

                    case 3:
                        System.out.print("Enter category: ");
                        String searchCategory = scanner.nextLine();
                        manager.searchByCategory(searchCategory);
                        break;

                    case 4:
                        double total = manager.calculateTotal();
                        System.out.println("Total Expenses: " + total);
                        break;

                    case 5:
                        System.out.print("Enter expense ID to delete: ");
                        int deleteId = Integer.parseInt(scanner.nextLine());
                        manager.deleteExpense(deleteId);
                        break;

                    case 6:
                        System.out.println("Thank you for using Personal Expense Tracker!");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                choice = 0;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                choice = 0;
            }

        } while (choice != 6);

        scanner.close();
    }
}
