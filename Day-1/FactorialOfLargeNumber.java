import java.math.BigInteger;
import java.util.Scanner;

public class FactorialOfLargeNumber {
    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;  
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));  
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number to calculate its factorial:");
        int n = scanner.nextInt();
        BigInteger result = factorial(n);
        System.out.println("Factorial of " + n + " is: ");
        System.out.println(result.toString()); 
        scanner.close();
    }
}
