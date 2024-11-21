import java.util.Stack;
import java.util.Scanner;

public class DeleteMiddleElement {
    public static void deleteMiddle(Stack<Integer> stack, int size, int cur) {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        if (cur != size / 2) {
            deleteMiddle(stack, size, cur + 1);
            stack.push(top);
        }
    }
    public static void deleteMiddleElement(Stack<Integer> stack) {
        int size = stack.size();
        deleteMiddle(stack, size, 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        System.out.print("Enter the number of elements in the stack: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            int element = sc.nextInt();
            stack.push(element);
        }
        System.out.println("Original Stack: " + stack);
        deleteMiddleElement(stack);
        System.out.println("Stack after deleting middle element: " + stack);
        sc.close();
    }
}
