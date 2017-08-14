
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicOperation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		AtomicSample a1 = new AtomicSample();
		Thread t1 = new Thread(a1);
		Thread t2 = new Thread(a1);
		Thread t3 = new Thread(a1);
		Thread t4 = new Thread(a1);
		Thread t5 = new Thread(a1);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(a1.getCount() + " " + a1.counter);
		
	}

}

class AtomicSample implements Runnable
{
	AtomicInteger count = new AtomicInteger();
	int counter = 0;
	
	void incrementCount()
	{
		count.incrementAndGet();
	}
	
	int getCount()
	{
		return count.get();
	}

	public void run() {
		for(int i=0; i <10000; i++)
		{
			counter++;
			incrementCount();
			//counter++;
		}
	}
	
	
}
