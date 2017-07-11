
public class StringReverse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcd";
		str = reverseStr(str);
		System.out.println("Reverse string ==> " + str);
		
		str = "abcd";
		str = reverseStr_AnotherWay(str, str.length());
		System.out.println("Reverse string ==> " + str);
		
	}

	private static String reverseStr(String str) 
	{
		if(str.length() <= 1) 
			return "" + str.charAt(0);
		return reverseStr(str.substring(1)) + str.charAt(0); 
	}
	
	private static String reverseStr_AnotherWay(String str, int lenght) 
	{
		if(lenght == 1) 
			return "" + str.charAt(0);
		return  str.charAt(lenght -1) + reverseStr_AnotherWay(str, lenght - 1); 
	}

}
