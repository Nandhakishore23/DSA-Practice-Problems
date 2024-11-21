import java.util.Scanner;

public class MaxOperationsInSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        StringBuilder result = new StringBuilder();
        
        while (t-- > 0) {
            long l = scanner.nextLong();
            long r = scanner.nextLong();
            long k = scanner.nextLong();
            
            if (l == r) {
                // If the range contains only one element
                result.append(1).append("\n");
                continue;
            }
            
            long left = l, right = r;
            long maxOperations = 0;
            
            while (left <= right) {
                long mid = left + (right - left) / 2;
                
                long multiples = (r / mid) - ((l - 1) / mid);
                
                if (multiples >= k) {
                    maxOperations = Math.max(maxOperations, multiples);
                    left = mid + 1;  // Search for a larger valid x
                } else {
                    right = mid - 1; // Search for a smaller valid x
                }
            }
            
            result.append(maxOperations).append("\n");
        }
        
        System.out.print(result);
        scanner.close();
    }
}
