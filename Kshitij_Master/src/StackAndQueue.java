
public class StackAndQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack s1 = new Stack(5);
		s1.push(10);
		s1.push(20);
		s1.push(30);
		s1.push(40);
		s1.push(50);
		
		s1.printElements();
		System.out.println();
		
		s1.pop();
		
		s1.printElements();
		System.out.println();
		
		/*Queue q1 = new Queue(5);
		q1.enqueue(10);
		q1.enqueue(20);
		q1.enqueue(30);
		q1.enqueue(40);
		q1.enqueue(50);
		
		q1.printElements();
		System.out.println();
		
		q1.dequeue();
		
		q1.printElements();
		System.out.println();
		
		QueueUsingTwoStacks q2 = new QueueUsingTwoStacks(5);
		q2.enqueue(10);
		q2.enqueue(20);
		q2.enqueue(30);
		q2.enqueue(40);
		q2.enqueue(50);
		
		q2.printElements();
		System.out.println();
		
		q2.dequeue();
		
		q2.printElements();
		System.out.println();*/
		
		/*QueueUsingTwoStacks_AnotherWay q3 = new QueueUsingTwoStacks_AnotherWay(5);
		q3.enqueue(10);
		q3.enqueue(20);
		q3.enqueue(30);
		q3.enqueue(40);
		q3.enqueue(50);
		
		q3.printElements();
		System.out.println("");
		
		q3.dequeue();
		
		q3.printElements();
		System.out.println();*/
		
		
	}

}

class Stack
{
	int top = -1;
	int[] arr;
	
	Stack(int size)
	{
		arr = new int[size];
	}
	
	public void push(int data)
	{
		arr[++top] = data;
	}
	
	public int pop()
	{
		return arr[top--];
	}
	
	public void printElements()
	{
		for(int i=top; i>=0; i--)
		{
			System.out.print(arr[i] + "==>");
		}
	}
	
	public boolean isEmpty()
	{
		return top < 0 ? true : false;
	}
	
	public int size()
	{
		return top + 1;
	}
}

class Queue
{
	int front = 0;
	int rear = -1;
	int[] arr;
	
	Queue(int size)
	{
		arr = new int[size];
	}
	
	public void enqueue(int data)
	{
		arr[++rear] = data;
	}
	
	public int dequeue()
	{
		return arr[front++];
	}
	
	public void printElements()
	{
		for(int i=front; i<=rear; i++)
		{
			System.out.print(arr[i] + "==>");
		}
	}
	
	public int size()
	{
		return rear - front + 1;
	}
	
	public boolean isEmpty()
	{
		if(front > rear || rear - front < 0)
			return true;
		return false;
	}
	
}

class QueueUsingLinkedList
{
	DoublyLinkedL_AnotherWay n;			//This has tail instance variable in Doubly Linked List
	QueueUsingLinkedList()
	{
		n = new DoublyLinkedL_AnotherWay();
	}
	
	public void enqueue(int data)
	{
		n.add(data);
	}
	
	public void dequeue()
	{
		n.head = n.head.next;
		n.head.prev.next = null;
		n.head.prev = null;
	}
	
}

class StackUsingLinkedList
{
	DoublyLinkedL_AnotherWay n;			//This has tail instance variable in Doubly Linked List
	StackUsingLinkedList()
	{
		n = new DoublyLinkedL_AnotherWay();
	}
	
	public void push(int data)
	{
		n.add(data);
	}
	
	public void pop()
	{
		n.tail = n.tail.prev;
		n.tail.next.prev = null;
		n.tail.next = null;
	}
	
}


class QueueUsingTwoStacks
{
	Stack s1;
	Stack s2;
	
	QueueUsingTwoStacks(int size)
	{
		s1 = new Stack(size);
		s2 = new Stack(size);
	}
	
	public void enqueue(int data)
	{
		if(s1.top == -1)
			s1.push(data);
		else
		{
			while(!s1.isEmpty())
			{
				s2.push(s1.pop());
			}
			s1.push(data);
			while(!s2.isEmpty())
			{
				s1.push(s2.pop());
			}
		}
	}
	
	public int dequeue()
	{
		return s1.pop();
	}
	
	public void printElements()
	{
		s1.printElements();
	}
}

class QueueUsingTwoStacks_AnotherWay
{
	Stack s1;
	Stack s2;
	
	QueueUsingTwoStacks_AnotherWay(int size)
	{
		s1 = new Stack(size);
		s2 = new Stack(size);
	}
	
	public void enqueue(int data)
	{
		s1.push(data);
	}
	
	public int dequeue()
	{
		if(s2.isEmpty())
		{
			while(!s1.isEmpty())
			{
				s2.push(s1.pop());
			}
		}
		return s2.pop();
	}
	
	public void printElements()
	{
		if(!s2.isEmpty())
			s2.printElements();
		else
			s1.printElements();
	}
}
