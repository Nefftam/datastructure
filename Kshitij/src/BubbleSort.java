
public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {50, 20, 40};
		bubbleSort(arr);
		printArray(arr);
	}

	private static void printArray(int[] arr) 
	{
		for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
	}

	private static void bubbleSort(int[] arr) 
	{
		for(int i=0; i<arr.length; i++)
		{
			for(int j=0; j<arr.length - i - 1; j++)
			{
				if(arr[j] > arr[j+1])
					swap(j, j+1, arr);
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
