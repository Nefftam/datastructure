
public class MinHeap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryMinHeap minHeap = new BinaryMinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.printElement();
        
        int node = minHeap.extractMin();
        System.out.println("Removed Element is " + node);
        minHeap.printElement();
        
        minHeap.increaseKey(4, 24);
        minHeap.printElement();
        
        System.out.println("Deleting the Element");
        minHeap.delete(2);
        minHeap.printElement();
        
	}

}

class BinaryMinHeap
{
	int arr[];
	int front = 1;
	int rear = 0;
	BinaryMinHeap(int size)
	{
		arr = new int[size];
		arr[0] = Integer.MIN_VALUE;
	}
	

	public int leftChild(int index)
	{
		return 2 * index;
	}
	
	public int rightChild(int index)
	{
		return 2 * index + 1;
	}
	
	public int parentNode(int index)
	{
		return index / 2;
	}
	
	public boolean isLeaf(int index)
	{
		return index > rear/2 ? true : false;
	}
	
	public int getMin()
	{
		return arr[front];
	}
	
	public void insert(int data)
	{
		rear = rear +1;
		arr[rear] = data;
		int temp = rear;
		while(arr[parentNode(temp)] > arr[temp])
		{
			swap(parentNode(temp), temp);
			temp = parentNode(temp);
		}
	}
	
	private void swap(int currEle, int parentEle) 
	{
		int temp = arr[currEle];
		arr[currEle] = arr[parentEle];
		arr[parentEle] = temp;
	}
	
	//This pop the root element and re-iterate the whole tree
	public int extractMin()
	{
		int pop = arr[front];
		arr[front] = arr[rear];
		rear = rear -1;
		minHeapify(front);
		return pop;
	}
	
	//Assign the Min Value to the deleting Index. And then do extractMin.
	public void delete(int i) 
	{
		decreaseKey(i, Integer.MIN_VALUE);
		extractMin();
	}
	
	public void minHeapify(int pos) 
	{
		if(!isLeaf(pos))
		{
			if(arr[pos] > arr[leftChild(pos)] || arr[pos] > arr[rightChild(pos)])
			{
				if(arr[pos] > arr[leftChild(pos)])
				{
					swap(pos, leftChild(pos));
					minHeapify(leftChild(pos));
				}
				else
				{
					swap(pos, rightChild(pos));
					minHeapify(rightChild(pos));
				}
			}
		}
	}
	
	//Decreases value of key at index 'i' to new_val.
	public void decreaseKey(int index, int value) 
	{
		arr[index] = value;
		while(arr[parentNode(index)] > arr[index])
		{
			swap(parentNode(index), index);
			index = parentNode(index);
		}
	}
	
	public void increaseKey(int index, int value) 
	{
		arr[index] = value;
		minHeapify(index);
	}

	public void printElement()
	{
		for(int i=front; i <= rear/2; i++)
		{
			System.out.println("Parent => " + arr[i] + " Left Node => " + arr[leftChild(i)] + " Right Child => "+ arr[rightChild(i)]);
		}
	}
	
}
