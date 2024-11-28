import java.util.Scanner;

public class JumpGameTwo {
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0, end = 0, farthest = 0;
        for (int i = 0; i < n - 1; i++) { 
            farthest = Math.max(farthest, i + nums[i]); 
            if (i == end) {
                jumps++; 
                end = farthest; 
                if (end >= n - 1) break;
            }
        }
        return jumps;
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
        JumpGameTwo solution = new JumpGameTwo();
        int result = solution.jump(nums);
        System.out.println("Minimum number of jumps to reach the last index: " + result);
        sc.close();
    }
}
