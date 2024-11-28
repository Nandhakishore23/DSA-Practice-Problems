import java.util.Arrays;
import java.util.Scanner;
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = Integer.MAX_VALUE / 2;
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) { 
                int cur = nums[i] + nums[l] + nums[r];
                if (Math.abs(target - cur) < Math.abs(target - closestSum)) {
                    closestSum = cur;
                }
                if (cur < target) {
                    l++;
                } else if (cur > target) {
                    r--; 
                } else {
                    return target;
                }
            }
        }
        return closestSum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.print("Enter the target value: ");
        int target = sc.nextInt();
        ThreeSumClosest solution = new ThreeSumClosest();
        int result = solution.threeSumClosest(nums, target);
        System.out.println("Closest sum to target: " + result);
        sc.close();
    }
}
