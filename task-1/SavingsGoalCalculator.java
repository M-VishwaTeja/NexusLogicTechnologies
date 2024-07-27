import java.util.Scanner;

public class SavingsGoalCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the savings goal amount: ");
        double savingsGoal = sc.nextDouble();
        
        System.out.print("Enter the annual rate of return (in %): ");
        double annualRateOfReturn = sc.nextDouble();
        
        System.out.print("Enter the time frame (in years): ");
        int timeFrameInYears = sc.nextInt();
        
        double monthlyRateOfReturn = (annualRateOfReturn / 100) / 12;
        int numberOfMonths = timeFrameInYears * 12;
        
        double monthlyInvestment = (savingsGoal * monthlyRateOfReturn) / (Math.pow(1 + monthlyRateOfReturn, numberOfMonths) - 1);
        
        System.out.printf("The required monthly investment is: %.2f%n", monthlyInvestment);

    }
}
