import java.util.HashMap;
import java.util.Set;




public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int start = 0;
		int[] arr = {50, 20, 40};
		int end = arr.length -1;
		mergeSortUsingRecusrion(arr, start, end);
		printArray(arr);
		
	}

	private static void mergeSortUsingRecusrion(int[] arr, int start, int end) 
	{
		if(start < end)
		{
			int mid = (start + end)/2;
			mergeSortUsingRecusrion(arr, start, mid);
			mergeSortUsingRecusrion(arr, mid + 1, end);
			merge(arr, start, end);
		}
	}

	private static void merge(int[] arr, int start, int end) 
	{
		int mid = (start + end)/2;
		
		int lArrayLength = mid - start + 1;
		int rArrayLength = end- mid;
		int[] lArray = new int[lArrayLength];
		int[] rArray = new int[rArrayLength];		//end - (mid +1) -1
		
		for(int i=0; i<lArrayLength; i++)
		{
			lArray[i] = arr[start + i];
		}
		
		for(int i=0; i<rArrayLength; i++)
		{
			rArray[i] = arr[mid + 1 + i];
		}
		
		int i=0, j=0, k=0;
		while( i< lArrayLength && j < rArrayLength)
		{
			if(lArray[i] < rArray[j])
			{
				arr[k] = lArray[i];
				k = k+1;
				i= i+1;
			}
			else
			{
				arr[k] = rArray[j];
				k = k+1;
				j= j+1;
			}
		}
		
		while (i < lArrayLength)
	    {
	        arr[k] = lArray[i];
	        i++;
	        k++;
	    }
	 
	    while (j < rArrayLength)
	    {
	        arr[k] = rArray[j];
	        j++;
	        k++;
	    }
	}

	private static void printArray(int[] arr) 
	{
		for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
	}



}
