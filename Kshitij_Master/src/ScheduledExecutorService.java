import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorService {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		java.util.concurrent.ScheduledExecutorService executor = java.util.concurrent.Executors.newScheduledThreadPool(2);
		SchdeuleTask task1 = new SchdeuleTask ("Demo Task 1");
		SchdeuleTask task2 = new SchdeuleTask ("Demo Task 2");
         
        System.out.println("The time is : " + new Date());
         
        executor.schedule(task1, 0 , TimeUnit.SECONDS);
        executor.schedule(task2, 0 , TimeUnit.SECONDS);
        executor.shutdown();
         
        try {
              executor.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
              e.printStackTrace();
        }
        System.out.println("hhhh");
        
        //Schedule a task to execute periodically
        java.util.concurrent.ScheduledExecutorService executor1 = java.util.concurrent.Executors.newScheduledThreadPool(1);
        SchdeuleTask task3 = new SchdeuleTask ("Demo Task 1");
         
        System.out.println("The time is : " + new Date());
         
//        java.util.concurrent.ScheduledFuture<?> result = executor.scheduleAtFixedRate(task3, 2, 5, TimeUnit.SECONDS);
        //scheduledAtFixedRate() method. This method accepts four parameters:
	        //the task you want to execute periodically,
	        //the delay of time until the first execution of the task,
	        //the period between two executions,
	        //and the time unit of the second and third parameters.
         
        try {
            TimeUnit.MILLISECONDS.sleep(20000);
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
         
        //executor.shutdown();
        //The default behavior is that the scheduled tasks finish when shutdown() call that method. 
        //You can change this behavior using the setContinueExistingPeriodicTasksAfterShutdownPolicy() 
        //method of the ScheduledThreadPoolExecutor class with a true value. The periodic tasks won’t finish upon calling the shutdown() method.
	}

}

class SchdeuleTask implements Runnable
{
    private String name;
 
    public SchdeuleTask(String name) {
        this.name = name;
    }
     
    public String getName() {
        return name;
    }
 
    public void run() 
    {
        try {
        	Thread.sleep(600);
            System.out.println("Doing a task during : " + name + " - Time - " + new Date());
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}