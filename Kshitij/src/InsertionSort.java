
public class InsertionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = {50, 20, 40};
		insertionSort(arr);
		printArray(arr);
	}

	private static void printArray(int[] arr) 
	{
		for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
	}

	private static void insertionSort(int[] arr) 
	{
		for(int i=1; i<arr.length; i++)
		{ 
			for(int j=i; j>0 && arr[j -1] > arr[j]; j--)
			{
				swap(j-1, j, arr);
			}
			
		}
	}

	private static void swap(int i, int j, int[] arr) 
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
