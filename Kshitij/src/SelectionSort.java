
public class SelectionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = {50, 20, 40};
		selectionSort(arr);
		printArray(arr);
	}

	private static void printArray(int[] arr) 
	{
		for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
	}

	private static void selectionSort(int[] arr) 
	{
		for(int i=0; i<arr.length -1; i++)
		{ 
			int max = i;
			for(int j=0; j<arr.length -i -1; j++)
			{
				if(arr[j] > arr[max])
					max = j;
			}
			swap(arr.length - i -1, max, arr);
		}
	}

	private static void swap(int i, int j, int[] arr) 
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
