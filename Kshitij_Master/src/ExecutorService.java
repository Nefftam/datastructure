public class ExecutorService {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		java.util.concurrent.ExecutorService executor = java.util.concurrent.Executors.newCachedThreadPool();
		//java.util.concurrent.ExecutorService executor = java.util.concurrent.Executors.newCachedThreadPool();
        for (int i = 0; i <= 5; i++) 
        {
        	Tasks task = new Tasks("Task " + i);
            System.out.println("A new task has been added : " + task.getName());
            executor.execute(task);
        }
        executor.shutdown();
        
        //Another way to use ExecutorService with submit method 
        java.util.concurrent.ExecutorService executor1 = java.util.concurrent.Executors.newSingleThreadExecutor();
        for (int i = 0; i <= 5; i++) 
        {
        	Tasks task = new Tasks("Task " + i);
            System.out.println("A new task has been added by submit method: " + task.getName());
            executor1.submit(task);
        }
        executor1.shutdown();
	}

}

class Tasks implements Runnable
{
	
	String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Tasks(String name)
	{
		this.name = name;
	}

	public void run() 
	{
		System.out.println("Doing a task during : " + name + " thread name " + Thread.currentThread().getName());
	}
}
