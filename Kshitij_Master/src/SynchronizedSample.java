
public class SynchronizedSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SynchronizedClass sc = new SynchronizedClass();
        SynchronizedClass sc1 = new SynchronizedClass();
        AccessSynchroziedMethods asm = new AccessSynchroziedMethods(sc);
        AccessSynchroziedMethods asm1 = new AccessSynchroziedMethods(sc1);
        Thread t7 = new Thread(asm);
        Thread t8 = new Thread(asm1);
        t7.start();
        t8.start();
	}

}

class AccessSynchroziedMethods extends Thread
{
	SynchronizedClass sc;
	AccessSynchroziedMethods(SynchronizedClass sc)
	{
		this.sc = sc;
	}
	public void run()
	{
		sc.display1();
		sc.display2();
		sc.display3();
		sc.display4();
		sc.display5();
		sc.display6();
	}
}

class SynchronizedClass
{
	synchronized void display1()
	{
		System.out.println("Print 1 " + Thread.currentThread().getName());
		System.out.println("Print 2 " + Thread.currentThread().getName());
	}
	synchronized void display2()
	{
		System.out.println("Print 3 " + Thread.currentThread().getName());
		System.out.println("Print 4 " + Thread.currentThread().getName());
	}
	void display3()
	{
		System.out.println("Print 5 " + Thread.currentThread().getName());
		System.out.println("Print 6 " + Thread.currentThread().getName());
	}
	void display4()
	{
		System.out.println("Print 7 " + Thread.currentThread().getName());
		System.out.println("Print 8 " + Thread.currentThread().getName());
	}
	synchronized static void display5()
	{
		System.out.println("Print 9 " + Thread.currentThread().getName());
		System.out.println("Print 10 " + Thread.currentThread().getName());
	}
	static void display6()
	{
		System.out.println("Print 11 " + Thread.currentThread().getName());
		System.out.println("Print 12 " + Thread.currentThread().getName());
	}
}
