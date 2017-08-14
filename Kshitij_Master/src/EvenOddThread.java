public class EvenOddThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CounterThread c = new CounterThread();
		Thread threadA = new Thread(c);
        Thread threadB = new Thread(c);
        threadA.start();
        threadB.start();
        //System.out.println(Thread.currentThread().getName());
        
	}

}

class CounterThread implements Runnable 
{
    public static int counter = 0;
    public static int turn = 0;
    public static Object lock = new Object();

    public void run() {
    	synchronized (lock) 
    	{
    		while(counter < 50)
    		{
    			if(turn == 0)
    			{
    				counter = counter + 1;
    				System.out.println("Flip. " + "Counter value " + counter + " Thread " + Thread.currentThread().getName());
    				turn = 1;
    				try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
    			}
    			else
    			{
    				counter = counter + 1;
    				System.out.println("Flop. " + "Counter value " + counter+ " Thread " + Thread.currentThread().getName());
    				turn = 0;
    				try {
						lock.notify();
					} catch (Exception e) {
						e.printStackTrace();
					}
    			}
    		}
			
		}
		
	}
}