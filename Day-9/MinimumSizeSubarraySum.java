import java.util.Scanner;
class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int l = 0; 
        int sum = 0; 
        for (int i = 0; i < n; i++) {
            sum += nums[i]; 
            while (sum >= target) {
                min = Math.min(min, i - l + 1);
                sum -= nums[l]; 
                l++;
            }
        }
        return min != Integer.MAX_VALUE ? min : 0; 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the target sum:");
        int target = sc.nextInt();
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
        System.out.println("Enter the array elements:");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        MinimumSizeSubarraySum solution = new MinimumSizeSubarraySum();
        int result = solution.minSubArrayLen(target, nums);
        System.out.println("The minimum length of the subarray is: " + result);
        sc.close();
    }
}
