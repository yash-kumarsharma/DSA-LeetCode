/*
LeetCode 141: Linked List Cycle
https://leetcode.com/problems/linked-list-cycle/

Approach:
Use Floyd’s Cycle Detection Algorithm (slow & fast pointers).
If there’s a cycle, the fast and slow pointers will eventually meet.
Time Complexity: O(n)
Space Complexity: O(1)
*/


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return true;
        }
        return false;
    }

    // --- For local testing ---
    public static void main(String[] args) {
        // Create test list: 3 -> 2 -> 0 -> -4
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);

        // Create a cycle: last node (-4) points to node 2
        head.next.next.next.next = head.next;

        LinkedListCycle solution = new LinkedListCycle();
        System.out.println("Has cycle: " + solution.hasCycle(head));
    }
}
