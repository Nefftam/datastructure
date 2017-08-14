
public class Lock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class LockSample
{
	boolean islocked;
	synchronized void lock(){
		while(islocked)				//Spin Lock. In case of Spurious Wakeup, while loop make sense to check the condition before exiting the loop. 
		{
			try {
				wait();
			} catch (InterruptedException e) {
				
			}
		}
		islocked = true;
	}
	
	synchronized void unclock()
	{
		islocked = false;
		notify();
	}
}
