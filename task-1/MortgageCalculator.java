import java.util.Scanner;
class MortgageCalculator{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //loan amount P, interest rate r , loan term in yrs n*12
        System.out.print("Loan Amount :");
        double loanAmount = sc.nextDouble();
        System.out.print("Interest rate :");
        double annualIntRate = sc.nextDouble();
        System.out.print("Loan term in years :");
        int loanTerm = sc.nextInt();

        double monthlyIntRate = (annualIntRate/100)/12;
        int numOfPayments = loanTerm*12;

        double monthlyMortgageAmount = (loanAmount*monthlyIntRate*Math.pow(1+monthlyIntRate,numOfPayments))/(Math.pow(1+monthlyIntRate,numOfPayments)-1);

        System.out.printf("Monthly mortgage amount = %.2f%n",monthlyMortgageAmount);
    }

}