import java.util.Scanner;

public class FinancialPlanningToolkit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Financial Planning Toolkit");
            System.out.println("1. Mortgage Calculator");
            System.out.println("2. Investment Return Calculator");
            System.out.println("3. Savings Goal Calculator");
            System.out.println("4. Income Tax Calculator (Optional)");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    MortgageCalculator.main(args);
                    break;
                case 2:
                    InvestmentReturnCalculator.main(args);
                    break;
                case 3:
                    SavingsGoalCalculator.main(args);
                    break;
                case 4:
                    IncomeTaxCalculator.main(args);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
