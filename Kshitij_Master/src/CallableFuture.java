import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;

public class CallableFuture {

	/**
	 * @param args
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException 
	{
		java.util.concurrent.ThreadPoolExecutor executor = (java.util.concurrent.ThreadPoolExecutor) java.util.concurrent.Executors.newFixedThreadPool(2);
		
		ExecutorCompletionService<Integer> service = new ExecutorCompletionService<Integer>(executor);
        int numbers[] = {4, 6, 2, 8};
        List list = new ArrayList();
        for(int i=0; i<numbers.length; i++)
        {
            FactorialCalculator calculator  = new FactorialCalculator(numbers[i]);
            java.util.concurrent.Future result = executor.submit(calculator);
            list.add(result);
        }
        for(int i=0; i<numbers.length; i++)
        {
        	java.util.concurrent.Future res = (Future) list.get(i);
        	System.out.println(res.isDone() + "->" +res.get());
        }
        //shut down the executor service now
        executor.shutdown();
        
	}

}

class FactorialCalculator implements java.util.concurrent.Callable<Integer>
{
 
    private Integer number;
 
    public FactorialCalculator(Integer number) {
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