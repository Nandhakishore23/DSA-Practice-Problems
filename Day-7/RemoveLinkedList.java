import java.util.Scanner;
class RemoveLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode cur = new ListNode(0); 
        ListNode top = cur;
        cur.next = head;
        while (top.next != null) {
            if (top.next.val == val) {
                top.next = top.next.next; 
            } else {
                top = top.next;
            }
        }
        return cur.next;
    }
    private static ListNode createLinkedList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }
    private static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in the linked list:");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the linked list:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Enter the value to remove:");
        int val = scanner.nextInt();
        ListNode head = createLinkedList(arr);
        RemoveLinkedList solution = new RemoveLinkedList();
        ListNode updatedHead = solution.removeElements(head, val);
        System.out.println("Updated linked list:");
        printLinkedList(updatedHead);
        scanner.close();
    }
}
