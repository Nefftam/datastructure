
public class JoinThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 TestJoinMethod1 t1=new TestJoinMethod1();  
		 TestJoinMethod1 t2=new TestJoinMethod1();  
		 TestJoinMethod1 t3=new TestJoinMethod1();  
		 t1.start();  
		 try
		 {  
			 t1.join();  
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }  
		  
		 t2.start();  
		 t3.start();  
	}

}

//It causes the currently running threads to stop executing until the thread it joins with completes its task.
class TestJoinMethod1 extends Thread {
	public void run() 
	{
		for (int i = 1; i <= 5; i++) 
		{
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println(i);
		}
	}
}