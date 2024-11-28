import java.util.Scanner;
class MinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int min = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                min = nums[i];
                break;
            }
        }
        return min == -1 ? nums[0] : min;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the rotated sorted array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        MinimumInRotatedSortedArray sol = new MinimumInRotatedSortedArray();
        int minElement = sol.findMin(nums);
        System.out.println("The minimum element is: " + minElement);
        sc.close();
    }
}
