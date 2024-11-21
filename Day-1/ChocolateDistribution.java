import java.util.Arrays;
import java.util.Scanner;

public class ChocolateDistribution {
    public static int findMinDifference(int[] arr, int m) {
        int n = arr.length;
        if (n < m) {
            return -1;
        }
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i + m - 1 < n; i++) {
            int currentDiff = arr[i + m - 1] - arr[i];
            minDiff = Math.min(minDiff, currentDiff);
        }
        return minDiff;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	System.out.println("Enter the elements of the chocolates separated by spaces:");
        String inputLine = scanner.nextLine();
        String[] inputStrings = inputLine.split(" ");
        int[] arr = new int[inputStrings.length];
        for (int i = 0; i < inputStrings.length; i++) {
            arr[i] = Integer.parseInt(inputStrings[i]);
        }
	System.out.println("Enter the number of students (m):");
        int m = scanner.nextInt();
        int result = findMinDifference(arr, m);
        System.out.println("The minimum difference is: " + result);
        scanner.close();
    }
}
