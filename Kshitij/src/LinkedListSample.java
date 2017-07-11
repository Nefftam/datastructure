public class LinkedListSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedL n = new LinkedL();
		n.add(10);
		n.add(20);
		n.add(30);
		n.add(40);
		n.add(50);
		
		n.printElement();
		System.out.println();
		
		int search = n.search(30);
		System.out.println("Element Index " + search);
		
		n.printInReverseOrder(n.head);
		System.out.println("----Print in Reverse Order----");
		
		n.head = n.reverseLinkedList(n.head);
		n.printElement();
		System.out.println();
		
		int ele = n.midElement(n.head);
		System.out.println("Mid Element is " + ele);
		
		
		
	}

}


class Node
{
	int value;
	Node next;
	Node(int x)
	{
		this.value = x;
		next = null;
	}
}

class LinkedL
{
	Node head;
	
	public void add(int key)
	{
		if(head == null)
			head = new Node(key);
		else
		{
			Node curr = head;
			while(curr.next != null)
			{
				curr = curr.next;
			}
			Node newN = new Node(key);
			curr.next = newN;
			
		}
	}
	
	public int midElement(Node head) 
	{
		Node prev = head;
		Node curr = head;
		while (curr.next != null && curr.next.next != null)
		{
			prev = curr.next;
			curr = curr.next.next;
		}
		return prev.value;
	}

	public Node reverseLinkedList(Node head) 
	{
		Node prev = null;
		Node curr = head;
		while(head != null)
		{
			head = head.next;
			curr.next = prev;
			prev = curr;
			curr = head;
		}
		return prev;
	}

	public int search(int key)
	{
		if(head == null)
			return -1;
		if(head.value ==  key)
			return 0;
		Node curr = head;
		int count = 0;
		while(curr != null)
		{
			count++;
			if(curr.value == key)
			{
				return count;
			}
			curr = curr.next;
		}
		return -1;
	}
	
	public void printElement()
	{
		Node curr = head;
		while(curr != null)
		{
			System.out.print(curr.value + "-->");
			curr = curr.next;
		}
	}
	
	public void  printInReverseOrder(Node head) 
	{
		if(head != null)
		{
			printInReverseOrder ( head.next);
			System.out.print(head.value + "-->");
		}
	}
}