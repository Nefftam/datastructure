public class MaxHeap {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		BinaryMaxHeap maxHeap = new BinaryMaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
        maxHeap.print();
        
        int node = maxHeap.extractMax();
        System.out.println("Removed Element is " + node);
        
        maxHeap.print();
        
        maxHeap.increaseKey(4, 24);
        maxHeap.print();
        
        maxHeap.decreaseKey(4, 2);
        maxHeap.print();
        
        maxHeap.delete(2);
        maxHeap.print();
	}

}

class BinaryMaxHeap
{
	int[] hAr;
	int rear = 0;
	int front = 1;			//Front will give the max element. 
	
	public BinaryMaxHeap(int size) 
	{
		hAr = new int[size];
		hAr[0] = Integer.MAX_VALUE;
	}
	
	int getMax()
	{
		return hAr[front];
	}
	
	int left(int rootPosition)
	{
		return 2 * rootPosition;
	}
	
	int right(int rootPosition)
	{
		return (2 * rootPosition) + 1;
	}
	
	int parent(int position)
	{
		return position / 2; 
	}
	
	//Add the element.
	//Now check the current element added with parent. If current element is greater than parent element, 
	//then swap the element and move the pointer to curr.
	void insert(int ele)
	{
		rear = rear + 1;
		hAr[rear] = ele;
		
		int curr = rear;
		while(hAr[curr] > hAr[parent(curr)])
		{
			swap(curr, parent(curr));
			curr = parent(curr);
		}
	}
	
	//Remove means removing the Max element.
	//Make rear as front.
	//Now check if the Front is not leaf, then curr should be greater than both left and right child node.
	//If not, swap the node accordingly and again iterate same array.
	
	int extractMax()
	{
		int pop = hAr[front];
		hAr[front] = hAr[rear];
		hAr[rear] = 0;
		rear = rear - 1;
		maxHeapify(front);
		return pop;
	}
	
	private boolean isLeaf(int pos)
	{
		if( pos > (rear / 2) )
			return true;
		else
			return false;
	}
	
	private void maxHeapify(int pos) 
	{
		if(!isLeaf(pos))
		{
			if(hAr[pos] < hAr[left(pos)] || hAr[pos] < hAr[right(pos)])
			{
				if(hAr[left(pos)] > hAr[pos])
				{
					swap(pos, left(pos));
					maxHeapify(left(pos));
				}
				else
				{
					swap(pos, right(pos));
					maxHeapify(right(pos));
				}
			}
		}
	}
	
	//Increases value of key at index 'i' to new_val.
	public void increaseKey(int index, int value) 
	{
		hAr[index] = value;
		while(hAr[parent(index)] < hAr[index])
		{
			swap(parent(index), index);
			index = parent(index);
		}
	}

	public void delete(int pos) 
	{
		increaseKey(pos, Integer.MAX_VALUE);
		extractMax();
	}

	public void decreaseKey(int index, int value) 
	{
		hAr[index] = value;
		maxHeapify(index);
	}

	public void print()
    {
        for (int i = 1; i <= rear/2; i++ )
        {
            System.out.print(" PARENT : " + hAr[i] + " LEFT CHILD : " + hAr[2*i] + " RIGHT CHILD :" + hAr[2 * i  + 1]);
            System.out.println();
        }
    }

	private void swap(int currEle, int parentEle) 
	{
		int temp = hAr[currEle];
		hAr[currEle] = hAr[parentEle];
		hAr[parentEle] = temp;
	}
}
