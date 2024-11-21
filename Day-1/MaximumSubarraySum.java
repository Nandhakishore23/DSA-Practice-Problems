import java.util.Scanner;

public class MaximumSubarraySum {
    public static int maxSubarraySum(int[] arr) {
        int maxCur = arr[0];
        int maxFin = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxCur = Math.max(arr[i], maxCur + arr[i]);
            if (maxCur > maxFin) {
                maxFin = maxCur;
            }
        }
        return maxFin;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the elements of the array separated by spaces:");
        String input = scanner.nextLine();
        String[] inputStrings = input.split(" ");
        int[] arr = new int[inputStrings.length];
        for (int i = 0; i < inputStrings.length; i++) {
            arr[i] = Integer.parseInt(inputStrings[i]);
        }
        int result = maxSubarraySum(arr);
        System.out.println("Maximum Subarray Sum: " + result);
        scanner.close();
    }
}
Time Complexity : o(n)
Space complexity : o(n)