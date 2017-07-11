import java.util.Stack;


public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {50, 20, 40};
		int start =0;
		int end = arr.length -1;
		quickSortUsingRecursion(arr, start, end);			//50>40 then i++ --> 20>40 is false then swap i and pI --> swap 50 and 40
		printArray(arr);
		
		int[] arr1 = {50, 20, 40};
		quickSortUsingIteration(arr1, start, end);
		printArray(arr1);
	}

	private static void quickSortUsingIteration(int[] arr1, int start, int end) 
	{
		Stack s = new Stack();
		s.push(start);
		s.push(end);
		while(!s.empty())
		{
			end = (Integer) s.pop();
			start = (Integer) s.pop();
			
			int pI = partitionIndex(arr1, start, end);
			if(pI -1 > start)		// If there are elements on left side of pivot
			{
				s.push(start);            
				s.push(pI - 1);
			}
			if(pI + 1 < end)	  // If there are elements on right side of pivot
			{
				s.push(pI + 1);
				s.push(end);
			}
			
		}
		
	}

	private static void printArray(int[] arr) 
	{
		for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
	}

	static int partitionIndex(int arr[], int start, int end)
	{
		int pI= start;
		int pivot = end;
		for(int i=0; i <= end -1; i++)
		{
			if(arr[i] < arr[pivot])
			{
				swap(i, pI, arr);
				pI++;
			}
		}
		swap(pI, pivot, arr);
		return pI;
	}

	private static void swap(int i, int j, int[] arr) 
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private static void quickSortUsingRecursion(int[] arr, int start, int end) 
	{
		if (start < end)
		{
			int pI = partitionIndex(arr, start, end);  
			quickSortUsingRecursion(arr, start, pI -1);
			quickSortUsingRecursion(arr, pI + 1, end);
		}
	}

}
