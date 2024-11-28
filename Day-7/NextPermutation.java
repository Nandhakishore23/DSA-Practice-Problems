import java.util.Scanner;
class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            reverse(nums, 0, n - 1);
            return;
        }
        for (int i = n - 1; i > index; i--) {
            if (nums[index] < nums[i]) {
                swap(nums, index, i);
                break;
            }
        }
        reverse(nums, index + 1, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int index, int i) {
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        NextPermutation solution = new NextPermutation();
        solution.nextPermutation(nums);
        System.out.println("Next permutation:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        scanner.close();
    }
}
