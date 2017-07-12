
public class CyclicBehavioOfLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedL cycleLink = new LinkedL();
		cycleLink.head = new Node(1);
		cycleLink.head.next = new Node(2);
		cycleLink.head.next.next = new Node(3);
		cycleLink.head.next.next.next = new Node(4);
		cycleLink.head.next.next.next.next = new Node(5);
		cycleLink.head.next.next.next.next.next = cycleLink.head.next;
		
		boolean isCycle = isLinkedListHavingCyclicBehavior(cycleLink.head);
		System.out.println("Is Linked List haing Cyclic Behavior " + isCycle);
		
		removeCyclicBehavior(cycleLink.head);
		
		isCycle = isLinkedListHavingCyclicBehavior(cycleLink.head);
		System.out.println("Is Linked List haing Cyclic Behavior " + isCycle);
		
		if(!isCycle)
			cycleLink.printElement();
	}

	private static void removeCyclicBehavior(Node head) 
	{
		Node slow = head;
		Node fast = head;
		while(slow != null && slow.next != null && fast != null && fast.next != null && fast.next.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
			if(slow.value == fast.value)
				break;
		}
		Node newPointer = head;
		Node prevPointer = slow;
		while(newPointer != null && slow != null)
		{
			if(slow == newPointer)
			{
				prevPointer.next = null;
				break;
			}
			prevPointer = slow;
			slow = slow.next;
			newPointer = newPointer.next;
		}
	}

	private static boolean isLinkedListHavingCyclicBehavior(Node head) 
	{
		Node slow = head;
		Node fast = head;
		while(slow != null && slow.next != null && fast != null && fast.next != null && fast.next.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
			if(slow.value == fast.value)
				return true;
		}
		return false;
	}

}
