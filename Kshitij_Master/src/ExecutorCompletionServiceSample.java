import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;


public class ExecutorCompletionServiceSample {

	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws ExecutionException 
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		java.util.concurrent.ThreadPoolExecutor executor = (java.util.concurrent.ThreadPoolExecutor) java.util.concurrent.Executors.newFixedThreadPool(2);
		ExecutorCompletionService<Integer> service = new ExecutorCompletionService<Integer>(executor);
        int numbers[] = {4, 6, 2, 8};
        for(int i=0; i<numbers.length; i++)
        {
        	service.submit(new FactorialCalculator(numbers[i]));
        }
        
        for(int i=0; i<numbers.length; i++)
        {
        	final Future<Integer> res = service.take();
        	System.out.println(res.isDone() + "->" +res.get());
        }
        //shut down the executor service now
        executor.shutdown();
	}

}

class Factorial implements java.util.concurrent.Callable<Integer>
{
 
    private Integer number;
 
    public Factorial(Integer number) {
        this.number = number;
    }
 
    public Integer call() throws Exception {
    	if(number==2)
    	{
    		Thread.sleep(5000);
    	}
        int result = 1;
        if ((number == 0) || (number == 1)) {
            result = 1;
        } else {
            for (int i = 2; i <= number; i++) {
                result *= i;
            }
        }
        System.out.println("Result for number - " + number + " -> " + result);
        return result;
    }
}