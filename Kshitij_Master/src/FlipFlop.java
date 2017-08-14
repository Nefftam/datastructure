
public class FlipFlop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FlipFlopSample ff = new FlipFlopSample();
		Flip flip = new Flip(ff);
		Flop flop = new Flop(ff);
		Thread t1 = new Thread(flip);
		t1.start();
		
		Thread t2 = new Thread(flop);
		t2.start();
	}

}

class FlipFlopSample
{
	boolean toogle;
	
	synchronized void printFlip() throws InterruptedException
	{
		while(toogle)
		{
			wait();
		}
		System.out.println("Flip");
		toogle = true;
		notifyAll();
	}
	
	synchronized void printFlop() throws InterruptedException
	{
		while(!toogle)
		{
			wait();
		}
		System.out.println("Flop");
		toogle = false;
		notifyAll();
	}
}
class Flip extends Thread
{
	FlipFlopSample flipFlop;
	Flip(FlipFlopSample flipFlop)
	{
		this.flipFlop = flipFlop;
	}
	public void run()
	{
		for(int i=0; i<5; i++)
		{
			try {
				flipFlop.printFlip();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class Flop extends Thread
{
	FlipFlopSample flipFlop;
	Flop(FlipFlopSample flipFlop)
	{
		this.flipFlop = flipFlop;
	}
	public void run()
	{
		for(int i=0; i<5; i++)
		{
			try {
				flipFlop.printFlop();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
