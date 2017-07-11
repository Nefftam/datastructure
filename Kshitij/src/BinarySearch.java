
public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10, 20, 30};
		int key = 30;
		int searchPosition = binarySerach(arr, key, 0, arr.length);
		System.out.println("Element position " + searchPosition);
	}

	private static int binarySerach(int[] arr, int key, int start, int end)
	{
		while(start < end)
		{
			int mid = (start + end) / 2;
			if (key == arr[mid])
                return mid;
			if(key < arr[mid])
				end =  mid -1;
			else
				start = mid +1;
		}
		return -1;
	}

}
