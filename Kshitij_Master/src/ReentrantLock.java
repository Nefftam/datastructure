
public class ReentrantLock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}



/*Synchronized blocks in Java are reentrant. This means, that if a Java thread enters a synchronized block of code, 
 and thereby take the lock on the monitor object the block is synchronized on, the thread can enter other Java code blocks synchronized on the same monitor object. 
 Here is an example:

public class Reentrant{

  public synchronized outer(){
    inner();
  }

  public synchronized inner(){
    //do something
  }
}

Notice how both outer() and inner() are declared synchronized, which in Java is equivalent to a synchronized(this) block. 
If a thread calls outer() there is no problem calling inner() from inside outer(), since both methods (or blocks) are synchronized on the same monitor object ("this").
 If a thread already holds the lock on a monitor object, it has access to all blocks synchronized on the same monitor object. This is called reentrance. 
 The thread can reenter any block of code for which it already holds the lock.
*/

/*
 The lock implementation written in Lock.java is not reentrant.
 A thread calling outer() will first lock the Lock instance. Then it will call inner(). Inside the inner() method the thread will again try to lock the Lock instance. 
 This will fail (meaning the thread will be blocked), since the Lock instance was locked already in the outer() method.

The reason the thread will be blocked the second time it calls lock() without having called unlock() in between
 */

class ReentrantLockSample
{

  boolean isLocked = false;
  int     lockedCount = 0;
  Thread  lockedBy = null;

  public synchronized void lock() throws InterruptedException
  {
		Thread callingThread = Thread.currentThread();
		while(isLocked && lockedBy != callingThread)
	    {
	      wait();
	    }
	    isLocked = true;
	    lockedCount++;
	    lockedBy = callingThread;
  }

  public synchronized void unlock()
  {
	  if(Thread.currentThread() == this.lockedBy)
	  {
	      lockedCount--;
	  }
      if(lockedCount == 0)
      {
        isLocked = false;
        notify();
      }
  }
}