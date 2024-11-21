import java.util.Scanner;
public class SearchInSortedAndRotatedArray {
    public static int search(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[left] <= arr[mid]) {
                if (arr[left] <= key && key < arr[mid]) {
                    right = mid - 1;  
                } else {
                    left = mid + 1;  
                }
            } else { 
                if (arr[mid] < key && key <= arr[right]) {
                    left = mid + 1;  
                } else {
                    right = mid - 1; 
                }
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the elements of the sorted and rotated array, separated by spaces:");
        String input = scanner.nextLine();
        String[] inputStrings = input.split(" ");
        int[] arr = new int[inputStrings.length];
        for (int i = 0; i < inputStrings.length; i++) {
            arr[i] = Integer.parseInt(inputStrings[i]);
        }
        System.out.println("Enter the key to search:");
        int key = scanner.nextInt();
        int result = search(arr, key);
        if (result != -1) {
            System.out.println("Key " + key + " found at index: " + result);
        } else {
            System.out.println("-1");
        }
        scanner.close();
    }
}
