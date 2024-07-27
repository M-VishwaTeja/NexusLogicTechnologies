import java.util.Scanner;

public class IncomeTaxCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter your annual income: ");
        double income = sc.nextDouble();
        
        double tax;
        
        if (income <= 9875) {
            tax = income * 0.10;
        } else if (income <= 40125) {
            tax = 9875 * 0.10 + (income - 9875) * 0.12;
        } else if (income <= 85525) {
            tax = 9875 * 0.10 + (40125 - 9875) * 0.12 + (income - 40125) * 0.22;
        } else {
            tax = 9875 * 0.10 + (40125 - 9875) * 0.12 + (85525 - 40125) * 0.22 + (income - 85525) * 0.24;
        }
        
        System.out.printf("Your estimated tax liability is: %.2f%n", tax);
    }
}
