
public class SemaphoreSample {

	public static void main(String[] args) 
	{
		SemaphoreExample sInstance = new SemaphoreExample();
		Thread t1 = new Thread(sInstance);
		Thread t2 = new Thread(sInstance);
		Thread t3 = new Thread(sInstance);
		Thread t4 = new Thread(sInstance);
		Thread t5 = new Thread(sInstance);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}

}

class SemaphoreExample extends Thread
{
	java.util.concurrent.Semaphore semap = new java.util.concurrent.Semaphore(3);
	int counter = 0;
	void printStatement()
	{
		try 
		{
			semap.acquire();
			System.out.println(Thread.currentThread().getName() + " is incrementing the counter");
			System.out.println(Thread.currentThread().getName() + " counter = " + counter++);
			System.out.println(Thread.currentThread().getName() + " is it done");
			System.out.println(Thread.currentThread().getName() + " it seems to be done");
			System.out.println(Thread.currentThread().getName() + " it seems to be done" + semap.availablePermits());
			semap.release();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public void run()
	{
		printStatement();
	}
}