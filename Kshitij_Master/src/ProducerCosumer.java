
public class ProducerCosumer {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		MyCup cup = new MyCup();
		
		ProducerOFMyCup p1 = new ProducerOFMyCup(cup,1);
		ConsumerOfMyCup c1 = new ConsumerOfMyCup(cup,1);
		ConsumerOfMyCup c2 = new ConsumerOfMyCup(cup,2);
		c1.start();
		
		p1.start();
		//c2.start();
		ProducerOFMyCup p2 = new ProducerOFMyCup(cup,2);
		//p2.start();
	}

}

class MyCup
{
	int contents;
	boolean isAvailable;
	
	synchronized public void put(int value) throws InterruptedException
	{
		//For inexplicable reasons it is possible for threads to wake up even if notify() and notifyAll() has not been called. 
		//This is known as spurious wakeups. Wakeups without any reason. 
		//To guard against spurious wakeups the signal member variable is checked inside a while loop instead of inside an if-statement.
		//Such a while loop is also called a spin lock.
		while(isAvailable)
		{
			wait();
		}
		isAvailable = true;
		contents = value;
		notifyAll();
	}
	
	synchronized public int get() throws InterruptedException
	{
		
		while(!isAvailable)
		{
			wait();
		}
		isAvailable = false;
		notifyAll();
		return contents;
	}
}

class ProducerOFMyCup extends Thread
{
	MyCup cup;
	int number;
	ProducerOFMyCup(MyCup cup, int number)
	{
		this.cup = cup;
		this.number = number;
	}
	public void run()
	{
		try {
			cup.put(number);
			System.out.println("Producer " + number);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
class ConsumerOfMyCup extends Thread
{
	MyCup cup;
	int number;
	ConsumerOfMyCup(MyCup cup, int number)
	{
		this.cup = cup;
		this.number = number;
	}
	public void run()
	{
		try {
			int value = cup.get();
			System.out.println("Consumer " + value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}