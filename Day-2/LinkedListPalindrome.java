import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListPalindrome {
    static Node insert(Node head, int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            return head;
        } else {
            Node t = head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = temp;
        }
        return head;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            Node head = null;
            String str[] = read.readLine().trim().split(" ");
            int listSize = str.length;
            for (int i = 0; i < listSize; i++) {
                head = insert(head, Integer.parseInt(str[i]));
            }
            boolean f = new Solution().isPalindrome(head);
            System.out.println(f ? "true" : "false");
	}
    }
}


class Solution {
    boolean isPalindrome(Node head) {
        Node curr = head;
        Stack<Integer> s = new Stack<>();
        while(curr != null){
            s.push(curr.data);
            curr = curr.next;
        }
        while(head != null){
            int c = s.pop();
            if(head.data != c){
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
