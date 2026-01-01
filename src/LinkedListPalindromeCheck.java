class  ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class LinkedListPalindromeCheck {


        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) return true;

            // 1) Find middle
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // 2) Reverse second half
            ListNode secondHalf = reverse(slow);

            // 3) Compare halves
            ListNode firstHalf = head;
            ListNode temp = secondHalf;
            while (temp != null) {
                if (firstHalf.val != temp.val) return false;
                firstHalf = firstHalf.next;
                temp = temp.next;
            }
            return true;
        }

        private ListNode reverse(ListNode curr) {
            ListNode prev = null;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
}
