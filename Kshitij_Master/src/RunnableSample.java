
public class RunnableSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadRunnableClass tr1 = new ThreadRunnableClass();
		Thread t1 = new Thread(tr1, "Kshitij Thread");
		t1.start();
		
		//Another way
		Thread t2 = new Thread(new Runnable()
		{
			public void run() {
				for(int i=0; i <5;i++)
				{
					System.out.println("Thread is " + java.lang.Thread.currentThread().getName() + " . Value is " + i);
				}
			}
			
		});
		t2.start();
	}

}

class ThreadRunnableClass implements Runnable
{
	public void run()
	{
		for(int i=0; i <5;i++)
		{
			System.out.println("Thread is " + java.lang.Thread.currentThread().getName() + " . Value is " + i);
		}
	}
}
