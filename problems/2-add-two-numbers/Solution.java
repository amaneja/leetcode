//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode current = dummyHead;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0) {
            //Fetch the numbers from each ListNode object
            int num1 = (l1 != null) ? l1.val : 0;
            int num2 = (l2 != null) ? l2.val : 0;

            //Calculate the carry value
            int totSum = num1 + num2 + carry;
            carry = totSum / 10;
            int currentDigit = totSum % 10;

            // Create new nodes for the result ListNode
            current.next = new ListNode(currentDigit);
            current = current.next;

            //Move to the next nodes in each input list
            if (l1 != null)
                l1 = l1.next;

            if (l2 != null)
                l2 = l2.next;
        }

        return dummyHead.next;
    }
}