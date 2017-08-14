
public class StaticSynchronize {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		MyThread1 t1=new MyThread1();  
		MyThread2 t2=new MyThread2();  
		MyThread3 t3=new MyThread3();  
		MyThread4 t4=new MyThread4(); 
		/*t1.start();  
		t2.start();  
		t3.start();  
		t4.start();*/
		
		A a1= new A();
		A a2= new A();
		Thread tt1= new Thread(a1);
		Thread tt2=new Thread(a2);
		tt1.start();
		tt2.start();
	}

}

class A extends Thread
{
	static int count ;
	synchronized static void incrementCount() {
		for (int i = 1; i <= 10000; i++) {
			count = count +1;
		}
		System.out.println(count);
	}
	public void run()
	{
		incrementCount();
	}
}

class Table {

	synchronized static void printTable(int n) {
		for (int i = 1; i <= 4; i++) {
			System.out.println(n * i);
			try {
				Thread.sleep(400);
			} catch (Exception e) {
			}
		}
	}
}

class MyThread1 extends Thread {
	public void run() {
		Table.printTable(1);
	}
}

class MyThread2 extends Thread {
	public void run() {
		Table.printTable(10);
	}
}

class MyThread3 extends Thread {
	public void run() {
		Table.printTable(100);
	}
}

class MyThread4 extends Thread {
	public void run() {
		Table.printTable(1000);
	}
}
