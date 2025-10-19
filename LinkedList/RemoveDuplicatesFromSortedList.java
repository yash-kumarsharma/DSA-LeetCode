/*
LeetCode 83: Remove Duplicates from Sorted List
https://leetcode.com/problems/remove-duplicates-from-sorted-list/

Approach:
Traverse the linked list using a pointer.
Whenever consecutive nodes have the same value, skip the duplicate node.
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

public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode temp = head;
        while (temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    // --- For local testing ---
    public static void main(String[] args) {
        // Input: 1 -> 1 -> 2 -> 3 -> 3
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));

        RemoveDuplicatesFromSortedList solution = new RemoveDuplicatesFromSortedList();
        ListNode result = solution.deleteDuplicates(head);

        // Output: 1 -> 2 -> 3
        while (result != null) {
            System.out.print(result.val + (result.next != null ? " -> " : ""));
            result = result.next;
        }
    }
}
