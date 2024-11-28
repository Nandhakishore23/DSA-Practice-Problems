import java.util.HashSet;
import java.util.Scanner;
class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = 0;
        HashSet<Character> charSet = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left)); 
                left++; 
            }
            charSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1); 
        }
        return maxLength;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string:");
        String s = sc.nextLine();
        LongestSubstringWithoutRepeating solution = new LongestSubstringWithoutRepeating();
        int result = solution.lengthOfLongestSubstring(s);
        System.out.println("The length of the longest substring without repeating characters is: " + result);
        sc.close();
    }
}
