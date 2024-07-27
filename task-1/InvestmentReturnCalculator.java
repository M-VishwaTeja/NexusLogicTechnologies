import java.util.*;
class InvestmentReturnCalculator{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //initial investment p, expected rate of return r, investment time horizon t
        //FV = p * (1+r)^t
        System.out.print("initial investment :");
        double p = sc.nextDouble();
        System.out.print("expected rate of return(%) :");
        double r = sc.nextDouble();
        System.out.print("investment time horizon :");
        int t = sc.nextInt();

        double FV  = p *(Math.pow(1+r/100,t));
        System.out.printf("FV : %.2f%n",FV);
    }
}