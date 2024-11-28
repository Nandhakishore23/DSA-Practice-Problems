import java.io.*;
import java.lang.*;
import java.util.*;

class ParanthesisChecker {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String st = sc.next();
            if (new Solution().isParenthesisBalanced(st) == true)
                System.out.println("true");
            else
                System.out.println("false");
            System.out.println("~");
        }
    }
}

class Solution { 
    static boolean isParenthesisBalanced(String s) {
        Stack<Character> st = new Stack<>();
		for(int i=0;i<s.length();i++){
			char ch = s.charAt(i);
			if(ch == '(' || ch == '{' || ch == '['){
				st.push(ch);
			}
			else if(ch == ')' || ch == '}' || ch == ']'){
				if(st.isEmpty()){
					return false;
				}
				char top = st.pop();
                if ((ch == '}' && top != '{') ||
                    (ch == ')' && top != '(') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
			}
		}
		return st.isEmpty();
    }
}
