/*
LeetCode 21: Merge Two Sorted Lists
https://leetcode.com/problems/merge-two-sorted-lists/

Approach:
Use a dummy head and merge two sorted lists by comparing nodes one by one.
Attach the smaller node to the result list and move the pointer forward.
Finally, attach any remaining nodes.

Time Complexity: O(m + n)
Space Complexity: O(1)
*/


public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        if (list1 != null) temp.next = list1;
        if (list2 != null) temp.next = list2;

        return dummy.next;
    }

    // --- For local testing ---
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        MergeTwoSortedLists solution = new MergeTwoSortedLists();
        ListNode result = solution.mergeTwoLists(list1, list2);

        // Expected Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4
        while (result != null) {
            System.out.print(result.val + (result.next != null ? " -> " : ""));
            result = result.next;
        }
    }
}
