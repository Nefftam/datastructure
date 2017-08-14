
public class HeapSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3, 1, 6, 5, 2, 4};
		//Build the Heap
		
		BinaryMinHeap min = new BinaryMinHeap(10);
		for(int i=0; i < arr.length; i++)
		{
			min.insert(arr[i]);
		}
		min.printElement();
		
		heapSort(min);
		
	}

	private static void heapSort(BinaryMinHeap min) 
	{
		int[] arr= min.arr;
		// TODO Auto-generated method stub
		for (int i=min.rear; i>=min.front; i--)
        {
            // Move current root to end
            int temp = arr[1];
            arr[1] = arr[i];
            arr[i] = temp;
 
            // call max heapify on the reduced heap
            int ele = min.extractMin();
            System.out.print(ele + "=>");
        }	
	}
}
