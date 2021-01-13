package q5;

import java.util.Scanner;

public class PrimeFactorTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the Prime Factorizer!");

        try {
            System.out.println("\nEnter a number to Prime Factorize Here: ");
            int num = Integer.valueOf(scan.nextLine());
            System.out.println("\nYou just entered: " + num);
            PrimeFactorizer myPF = new PrimeFactorizer(num);
            myPF.compute();
            myPF.getFactorsAndExponents(num,myPF.factors,myPF.exponents);
            myPF.toString();
        } catch (NumberFormatException e) {
            System.out.println("\nNot a valid number.");
        }
    }
}
