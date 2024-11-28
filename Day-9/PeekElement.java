import java.util.Scanner;
class PeekElement {
    public int findPeakElement(int[] nums) {
        int val = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                val = i;
            }
        }
        return val;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        PeekElement sol = new PeekElement();
        int peakIndex = sol.findPeakElement(nums);
        System.out.println("The peak element is at index: " + peakIndex);
        sc.close();
    }
}
