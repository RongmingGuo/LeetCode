//
import java.util.LinkedList;

public class LinkedListPlay {
	public static void main(String[] args){
		ListNode node0 = new ListNode();
		node0.value = 0;
		ListNode node1 = new ListNode();
		node1.value = 1;
		ListNode node2 = new ListNode();
		node2.value = 2;
		ListNode node3 = new ListNode();
		node3.value = 3;
		ListNode node4 = new ListNode();
		node4.value = 4;
		ListNode node5 = new ListNode();
		node5.value = 5;

		node5.next = null;
		node4.next = node5;
		node3.next = node4;
		node2.next = node3;
		node1.next = node2;
		node0.next = node1;
		
		print(node0);
		// Reverse the linkedList
		ListNode reversed = reverse(node0);
		print(reversed);
	}
	// Reversing a linkedlist
	public static ListNode reverse(ListNode list) {
		// Assume the linkedlist has length >= 3
		ListNode prev = list;
		ListNode curr = list.next;
		ListNode next = list.next.next;
		// Initial Operations
		prev.next = null;
		// Temporary storage of next
		while (next != null) {
			// Do
			curr.next = prev;
			// Update
			prev = curr;
			curr = next;
			next = next.next;
		}
		curr.next = prev;
		return curr;
	}

	// Print a linkedlist
	public static void print(ListNode list) {
		ListNode curr = list;
		while (curr != null) {
			System.out.print(curr.value + " ");
			curr = curr.next;
		}
		System.out.println("null");
	}
}