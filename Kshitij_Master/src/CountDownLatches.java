public class CountDownLatches {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		java.util.concurrent.CountDownLatch latch = new java.util.concurrent.CountDownLatch(2);
		new Thread(new Aggregrators(latch, "Kshitij")).start();
		new Thread(new Aggregrators(latch, "Kumar")).start();
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		new Thread(new Aggregrators(latch, "Ritu")).start();
		new Thread(new Aggregrators(latch, "Baranwal")).start();
		try {
			//This await is of no-use, as count down latch count down has reached to zero "0". 
			//So no threads will wait. 
			//While in case of cyclic barrier, it can be reset.
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Complete");
	}

}

class Aggregrators implements Runnable
{
	java.util.concurrent.CountDownLatch latch;
	String name;
	Aggregrators(java.util.concurrent.CountDownLatch latch, String name)
	{
		this.name = name;
		this.latch = latch;
	}
	public void run() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		latch.countDown();
		System.out.println("Thread Started " + name + " and count is " + latch.getCount());
	}
	
}
