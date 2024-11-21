import java.util.Scanner;

public class MaximumSubarrayProduct {
    public static int maxProduct(int[] arr) {
        int maxP = arr[0];
        int maxEnd = arr[0];
        int minEnd = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < 0) {
                int temp = maxEnd;
                maxEnd = minEnd;
                minEnd = temp;
            }
            maxEnd = Math.max(arr[i], maxEnd * arr[i]);
            minEnd = Math.min(arr[i], minEnd * arr[i]);
            maxP = Math.max(maxP, maxEnd);
        }
        return maxP;
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
        int result = maxProduct(arr);
        System.out.println("Maximum Product of Subarray: " + result);
        scanner.close();
    }
}

//Time Complexity : o(n)
//space complexity : o(n)