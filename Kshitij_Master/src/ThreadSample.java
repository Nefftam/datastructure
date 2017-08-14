
public class ThreadSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadClass threadClass1 = new ThreadClass();
		Thread t1 = new Thread(threadClass1);
		Thread t2 = new Thread(threadClass1);
		t1.start();
		t2.start();
		
		//Another way
		ThreadClass threadClass2 = new ThreadClass();
		threadClass2.start();
	}

}

class ThreadClass extends Thread
{
	public void run()
	{
		for(int i=0; i <5;i++)
		{
			System.out.println("Thread is " + java.lang.Thread.currentThread().getName() + " . Value is " + i);
		}
	}
}
