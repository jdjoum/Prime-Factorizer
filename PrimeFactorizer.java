package q5;

import java.util.ArrayList;


public class PrimeFactorizer {

    private int num;
    private boolean isFactored = false;
    ArrayList<Integer> factors = new ArrayList<Integer>();
    ArrayList<Integer> exponents = new ArrayList<Integer>();

    /**
     * Initialize the object with target number n.
     */
    public PrimeFactorizer(int n) {
        this.num = n;
    }

    /**
     * Return n, the target number.
     */
    public int getN() {
        return this.num;
    }

    /**
     * Compute factorization. Do not repeat operation if it was called before.
     */
    public void compute() {
        int temp = this.num;
        if(this.isFactored == true) {
            System.out.println("The number has already been factored.");
        } else {
            int count = 0;
            for(int i = 2; i <= this.num; i++) {
                count = 0;
                while(this.num % i == 0) {
                    this.num = this.num / i;
                    System.out.println("\nFactor: "+ i);
                    this.setFactors(i);
                    count++;
                }
                this.setExponents(count);
                this.isFactored = true;
            }
            if(this.num > 1) {
                System.out.println("Factor:" + this.num);
            }
        }
        this.num = temp;
    }

    /**
     * Return the factors and exponents in two arraylists. Call compute() first, if necessary.
     * For instance, if n=60, primes=[2,3,5], and exponents=[2,1,1].
     * This function overwrites the 'n' parameter passed to the constructor.
     */
    public void getFactorsAndExponents(int n, ArrayList<Integer> primes, ArrayList<Integer> exponents) {
        this.getFactors(this.factors);
        this.getExponents(this.exponents);
    }


    /**
     * Return a string with the "pretty" representation of the prime factorization.
     * For instance, if n is 60, then toString() for the PrimeFactorizer(60) object
     * should be "60 = 2^2*3*5". Call compute() if not done before.
     */
    public String toString() {
        int temp = this.num;
        String prettyString = "";
        int factorLength = this.factors.size();
        for(int i = 0; i < factorLength; i++) {
            if(i == (factorLength - 1)) {
                prettyString = prettyString + this.factors.get(i) + "^" + this.exponents.get(i);
            }
            else {
                prettyString = prettyString + this.factors.get(i) + "^" + this.exponents.get(i) + "*";
            }
        }
        System.out.println("\n" + temp + " = "+ prettyString);
        return prettyString;
    }

  // other code, helper functions, etc.
    public void setFactors(int factor) {
        int length = this.factors.size();
        if(length == 0) {
            this.factors.add(factor);
        } else if (length >= 1 && factor != this.factors.get(length - 1)) {
            this.factors.add(factor);
        } else {
            return;
        }
    }

    public void setExponents(int exponent) {
        int length = this.exponents.size();
        if(length == 0 && exponent != 0) {
            this.exponents.add(exponent);
        } else if (length >= 1 && exponent != 0) {
            this.exponents.add(exponent);
        } else {
            return;
        }
    }

    public void getExponents(ArrayList<Integer> exponents) {
        System.out.println("\nThe Exponents List: " + this.exponents);
    }

    public void getFactors(ArrayList<Integer> factors) {
        System.out.println("\nThe Factors List: " + this.factors);
    }
}
