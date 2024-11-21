import java.util.*;
public class ParanthesisBalanced{
	public static String isBalanced(String s){
		Stack<Character> st = new Stack<>();
		for(int i=0;i<s.length();i++){
			char ch = s.charAt(i);
			if(ch == '('){
				st.push(ch);
			}
			else if(ch == ')'){
				if(st.isEmpty()){
					return "Not Balanced";
				}
				st.pop();
			}
		}
		if(st.isEmpty()){
			return "Balanced";
		}
		else{
			return "Not Balanced";
		}
		
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string :");
		String s = sc.nextLine();
		String res = isBalanced(s);
		System.out.println(res);
		sc.close();
	}
}