import java.util.Date;
import java.util.concurrent.BrokenBarrierException;

public class CyclicBarrier {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		final java.util.concurrent.CyclicBarrier barriers = new java.util.concurrent.CyclicBarrier(3);
        Thread serviceOneThread1 = new Thread(new ServiceOne(barriers));
        Thread serviceTwoThread1 = new Thread(new ServiceTwo(barriers));
        serviceOneThread1.start();
        serviceTwoThread1.start();
        try {
        	barriers.await();			//Note: Here we are having 3 barrier point i.e. 2 in Runnable classes and another in Main thread. 
        								//So until and unless all three are not meeting to barrier point, it wont execute the next lines. 
        } catch (InterruptedException e) {
            System.out.println("Main Thread interrupted!");
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            System.out.println("Main Thread interrupted!");
            e.printStackTrace();
        }
        System.out.println("Ending both the services at "+new Date());
        
        barriers.reset();
		
        Thread.sleep(6000);
        
        serviceOneThread1 = new Thread(new ServiceOne(barriers));
        serviceTwoThread1 = new Thread(new ServiceTwo(barriers));
        serviceOneThread1.start();
        serviceTwoThread1.start();
        try {
        	barriers.await();
        } catch (InterruptedException e) {
            System.out.println("Main Thread interrupted!");
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            System.out.println("Main Thread interrupted!");
            e.printStackTrace();
        }
        System.out.println("Ending both the services at "+new Date());
        
	}

}

//One more Example:
//Suppose we have two services which should wait for each other to complete the execution. 
//Moreover the service calling them should also wait for their competition. 
//So in our example the 2 services and the main thread calling them will wait for each other to finish their execution.

class ServiceOne implements Runnable
{
	final java.util.concurrent.CyclicBarrier cyclicBarrier;
	
	public ServiceOne(java.util.concurrent.CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

	public void run()
	{
		System.out.println("Staring Service one");
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Service one has finished its work. Waiting for others..");
		try {
			cyclicBarrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Wait is Over, lets complete Service One..");
	}
}


class ServiceTwo implements Runnable
{
	final java.util.concurrent.CyclicBarrier cyclicBarrier;
	
	public ServiceTwo(java.util.concurrent.CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

	public void run()
	{
		System.out.println("Staring Service two");
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Service two has finished its work. Waiting for others..");
		try {
			cyclicBarrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Wait is Over, lets complete Service two..");
	}
}