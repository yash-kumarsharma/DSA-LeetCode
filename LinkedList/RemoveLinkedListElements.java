/*
LeetCode 203: Remove Linked List Elements
https://leetcode.com/problems/remove-linked-list-elements/

Approach:
1. Skip all leading nodes that match the target value.
2. Traverse the list and unlink any node whose next node has the target value.
3. Return the modified head.

Time Complexity: O(n)
Space Complexity: O(1)
*/


public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) return null;

        ListNode temp = head;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return head;
    }

    // --- For local testing ---
    public static void main(String[] args) {
        // Input: 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6, val = 6
        ListNode head = new ListNode(1,
                        new ListNode(2,
                        new ListNode(6,
                        new ListNode(3,
                        new ListNode(4,
                        new ListNode(5,
                        new ListNode(6)))))));

        RemoveLinkedListElements solution = new RemoveLinkedListElements();
        ListNode result = solution.removeElements(head, 6);

        // Expected Output: 1 -> 2 -> 3 -> 4 -> 5
        while (result != null) {
            System.out.print(result.val + (result.next != null ? " -> " : ""));
            result = result.next;
        }
    }
}
