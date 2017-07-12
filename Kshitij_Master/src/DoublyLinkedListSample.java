public class DoublyLinkedListSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedL n = new DoublyLinkedL();
		n.add(10);
		n.add(20);
		n.add(30);
		n.add(40);
		n.add(50);
		
		n.printElements();
		
		System.out.println();
		
		DoublyLinkedL_AnotherWay n1 = new DoublyLinkedL_AnotherWay();
		n1.add(10);
		n1.add(20);
		n1.add(30);
		n1.add(40);
		n1.add(50);
		
		n1.printElements();

	}

}

class N
{
	int value;
	N prev;
	N next;
	N(int x)
	{
		this.value = x;
	}
	
	public String toString()
	{
		return Integer.toString(value);
	}
}

class DoublyLinkedL
{
	N head;
	public void add(int key)
	{
		if(head == null)
		{
			head = new N(key);
		}
		else
		{
			N curr = head;
			while(curr.next != null)
			{
				curr = curr.next;
			}
			N newN = new N(key);
			
			curr.next = newN;
			newN.prev = curr;
		}
	}
	
	void printElements()
	{
		N curr = head;
		while(curr != null)
		{
			System.out.print(curr.prev + " -- " +curr.value + " -- " + curr.next +"-->");
			curr = curr.next;
		}

	}
}

class DoublyLinkedL_AnotherWay
{
	N head;
	N tail;
	public void add(int key)
	{
		if(head == null)
		{
			head = new N(key);
			tail = head;
		}
		else
		{
			N temp = new N(key);
			tail.next = temp;
			temp.prev = tail;
			tail = temp;
		}
	}
	
	void printElements()
	{
		N curr = head;
		while(curr != null)
		{
			System.out.print(curr.prev + " -- " +curr.value + " -- " + curr.next +"-->");
			curr = curr.next;
		}

	}
}