import java.util.Scanner;
class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                res = i;
                break;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array in sorted order:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.print("Enter the target value: ");
        int target = sc.nextInt();
        SearchInsertPosition sol = new SearchInsertPosition();
        int position = sol.searchInsert(nums, target);
        System.out.println("The target should be inserted at position: " + position);
        sc.close();
    }
}
