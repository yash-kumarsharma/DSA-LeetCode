/*
 LeetCode 206: Reverse Linked List
 https://leetcode.com/problems/reverse-linked-list/
 Approach: Iterative pointer reversal (O(n), O(1) space)
*/

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next; // temporarily store next
            curr.next = prev;              // reverse the pointer
            prev = curr;                   // move prev forward
            curr = nextNode;               // move curr forward
        }

        return prev; // new head
    }

    // Utility to print linked list
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

        ReverseLinkedList solution = new ReverseLinkedList();
        System.out.print("Original: ");
        printList(head);

        ListNode reversed = solution.reverseList(head);
        System.out.print("Reversed: ");
        printList(reversed);
    }
}
