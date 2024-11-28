import java.util.Scanner;
class FirstAndLastBinarySearch {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int l = binarySearch(nums, target, true);
        int r = binarySearch(nums, target, false);
        res[0] = l;
        res[1] = r;
        return res;
    }
    private int binarySearch(int[] nums, int target, boolean first) {
        int l = 0;
        int r = nums.length - 1;
        int index = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] > target) {
                r = m - 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                index = m;
                if (first) {
                    r = m - 1;
                } else {
                    l = m + 1; 
                }
            }
        }
        return index;
    }
    public static void main(String[] args) {	
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array (sorted):");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.print("Enter the target value: ");
        int target = sc.nextInt();
        FirstAndLastBinarySearch sol = new FirstAndLastBinarySearch();
        int[] range = sol.searchRange(nums, target);
        System.out.println("Range: [" + range[0] + ", " + range[1] + "]");
        sc.close();
    }
}
