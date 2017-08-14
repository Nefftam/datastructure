
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B11 b = new B11();
		System.out.println(b);
	}


}
class A11
{
	int i = 10;
	public String toString()
	{
		return "" + i;
	}
}
class B11 extends A11
{
	int j=20;
	public String toString()
	{
		
		return "" + j  + super.toString();
	}
}