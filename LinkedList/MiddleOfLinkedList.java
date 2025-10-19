/*
LeetCode 876: Middle of the Linked List
https://leetcode.com/problems/middle-of-the-linked-list/

Approach:
Use two pointers (slow and fast). 
Move `slow` by one step and `fast` by two steps.
When `fast` reaches the end, `slow` will be at the middle node.
Time Complexity: O(n)
Space Complexity: O(1)
*/


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MiddleOfLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // --- For local testing ---
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1,
                            new ListNode(2,
                                new ListNode(3,
                                    new ListNode(4,
                                        new ListNode(5)))));

        MiddleOfLinkedList solution = new MiddleOfLinkedList();
        System.out.print("Original List: ");
        printList(head);

        ListNode mid = solution.middleNode(head);
        System.out.println("Middle Node: " + mid.val);
    }
}
