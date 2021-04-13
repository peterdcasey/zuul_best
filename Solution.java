package zuul_best;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    
    public static void main(String[] args) {
        ListNode x = makeList(99999999999l);
        ListNode y = makeList(11111111111l);
        System.out.println(x + " " + y);
        //System.out.println(getNumber(x) + " " + getNumber(y) + " " + getNumber(x) + getNumber(y) );
        System.out.println(addTwoNumbers(x, y));
    }
    
    static ListNode addTwoNumbersX(ListNode l1, ListNode l2) {
        long num1 = getNumber(l1);
        long num2 = getNumber(l2);
        
        return makeList(num1 + num2);
    }
    
    static public long getNumber(ListNode x) {
        long num = (x != null) ? x.val : 0;
        long power = 10;
        
        while (x.next != null) {
            x = x.next;
            num = x.val * power + num;
            power *= 10;
        }
        
        return num;
    }

    static ListNode makeList(long num) {
        ListNode x = new ListNode((int)(num % 10));
        ListNode t = x;
        num = num / 10;
        
        while (num > 0) {
            t.next = new ListNode((int)(num % 10));
            t = t.next;
            num = num / 10;
        }
        
        return x;
    }
    
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode x = null;
        ListNode tmp = null;
        boolean first = true;
        int carry = 0;
        int sum = 0;
        int digit = 0;
        
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            //carry = (sum >= 10) ? 1 : 0;
            //digit = (carry == 1) ? sum - 10 : sum;
            carry = sum / 10;
            digit = sum % 10;
            
            if (first) {
                x = new ListNode(digit);
                tmp = x;
                first = false;
            }
            else {
                tmp.next = new ListNode(digit);
                tmp = tmp.next;
            }
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while (l1 != null) {
            sum = l1.val + carry;
            carry = sum / 10;
            digit = sum % 10;
            tmp.next = new ListNode(digit);
            tmp = tmp.next;
            l1 = l1.next;
        }
        
        while (l2 != null) {
            sum = l2.val + carry;
            carry = sum / 10;
            digit = sum % 10;
            tmp.next = new ListNode(digit);
            tmp = tmp.next;
            l2 = l2.next;
        }
        
        if (l1 == null && l2 == null && carry > 0) {
            tmp.next = new ListNode(carry);
        }
        
        return x;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      
      public String toString() {
          ListNode t = this;
          String result = "[";
          
          while (t != null) {
              result = result + t.val;
              t = t.next;
              String c = (t == null) ? "]" : ", ";
              result = result + c;
          }
          
          return result;
      }
 }
