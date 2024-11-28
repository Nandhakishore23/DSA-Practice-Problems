import java.util.Scanner;
class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) return false;
            l++;
            r--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string to check if it's a palindrome:");
        String input = sc.nextLine();
        ValidPalindrome solution = new ValidPalindrome();
        boolean result = solution.isPalindrome(input);
        System.out.println("Is the input string a palindrome? " + result);
        sc.close();
    }
}
