
public class LinearSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10, 20, 30};
		int key = 30;
		int searchPosition = linearSerach(arr, key);
		System.out.println("Element position " + searchPosition);
	}

	private static int linearSerach(int[] arr, int key) 
	{
		for(int i=0; i < arr.length; i++)
		{
			if(key == arr[i])
				return i+1;
		}
		return -1;
	}

}
