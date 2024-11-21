import java.util.Scanner;

public class TrappingRainwater {
    public static int calculateTrappedWater(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int waterTrapped = 0;
        while (left <= right) {
            if (arr[left] <= arr[right]) {
                if (arr[left] >= leftMax) {
                    leftMax = arr[left];
                } else {
                    waterTrapped += leftMax - arr[left];                
		}
                left++;
            } else {
                if (arr[right] >= rightMax) {
                    rightMax = arr[right]; 
                } else {
                    waterTrapped += rightMax - arr[right]; 
                }
                right--;
            }
        }
        return waterTrapped;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the elements of the elevation map, separated by spaces:");
        String inputLine = scanner.nextLine();
        String[] inputStrings = inputLine.split(" ");
        int[] arr = new int[inputStrings.length];
        for (int i = 0; i < inputStrings.length; i++) {
            arr[i] = Integer.parseInt(inputStrings[i]);
        }
        int result = calculateTrappedWater(arr);
        System.out.println("Total water trapped: " + result);
        scanner.close();
    }
}

// Time Complexity : o(n)
// Space Complexity  : o(1)
