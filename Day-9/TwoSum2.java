import java.util.Scanner;
import java.util.Arrays;
class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        int cs = numbers[l] + numbers[r];
        while (cs != target) {
            if (cs > target) {
                r--;
            } else {
                l++;
            }
            cs = numbers[l] + numbers[r];
        }
        return new int[]{++l, ++r}; 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
        System.out.println("Enter the sorted array elements:");
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        System.out.println("Enter the target:");
        int target = sc.nextInt();
        TwoSum2 solution = new TwoSum2();
        int[] result = solution.twoSum(numbers, target);
        System.out.println("Indices (1-based) of the two numbers: " + Arrays.toString(result));
        sc.close();
    }
}
