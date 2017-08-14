public class DeadLockThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/*final String resource1 = "Kshitij";
		final String resource2 = "Jinny";
		Thread t1 = new Thread() {
			public void run() {
				synchronized (resource1) {
					System.out.println("Thread 1: locked resource 1");

					try {
						Thread.sleep(100);
					} catch (Exception e) {
					}

					synchronized (resource2) {
						System.out.println("Thread 1: locked resource 2");
					}
				}
			}
		};

		// t2 tries to lock resource2 then resource1
		Thread t2 = new Thread() {
			public void run() {
				synchronized (resource2) {
					System.out.println("Thread 2: locked resource 2");

					try {
						Thread.sleep(50);
					} catch (Exception e) {
					}

					synchronized (resource1) {
						System.out.println("Thread 2: locked resource 1");
					}
				}
			}
		};

		t1.start();
		t2.start();
		*/
		
		A1 a1 = new A1();
		B1 b1 = new B1();
		C1 c1 = new C1(a1, b1);
		D1 d1 = new D1(a1, b1);
		//Below lines will end up in Deadlock state
		c1.start();
		d1.start();
		//
		
		///To solve the Deadlock state,  re-order the statements where code is accessing shared resources.
		E e1 = new E(a1, b1);
		//c1.start();
		//e1.start();
		///
	}

}


class A1
{
	private int i = 10;
	 
    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}

class B1
{
	private int i = 20;
	 
    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}

class C1 extends Thread
{
	A1 a1;
	B1 b1;
	C1(A1 a1, B1 b1)
	{
		this.a1 = a1;
		this.b1 = b1; 
	}
	
	public void run()
	{
		synchronized (a1) 
		{
            try 
            {
                Thread.sleep(100);
                System.out.println("Entering In block 1");
            } 
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
            // Thread-1 have A but need B also
            synchronized (b1) 
            {
                System.out.println("Exiting block 1");
            }
        }
	}
}

class D1 extends Thread
{
	A1 a1;
	B1 b1;
	D1(A1 a1, B1 b1)
	{
		this.a1 = a1;
		this.b1 = b1; 
	}
	
	public void run()
	{
		synchronized (b1) 
		{
			System.out.println("Entering In block 2");
	        // Thread-2 have B but need A also
	        synchronized (a1) 
	        {
	            System.out.println("Exiting block 2");
	        }
	    }
	}
	
}

class E extends Thread
{
	A1 a1;
	B1 b1;
	E(A1 a1, B1 b1)
	{
		this.a1 = a1;
		this.b1 = b1; 
	}
	
	public void run()
	{
		synchronized (a1) 
		{
			System.out.println("Entering In block 3");
	        // Thread-2 have B but need A also
	        synchronized (b1) 
	        {
	            System.out.println("Exiting block 3");
	        }
	    }
	}
	
}