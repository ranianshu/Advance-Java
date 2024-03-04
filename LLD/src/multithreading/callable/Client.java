package multithreading.callable;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
	
	public static void  main(String[] args) throws InterruptedException, ExecutionException {
		
		System.out.println("Main function thread: " + Thread.currentThread().getName());
		
		List<Integer> list = List.of(7, 3, 5, 1, 8, 2, 9);
		Sorter sorter = new Sorter(list);
		ExecutorService executerService = Executors.newCachedThreadPool();
		Future<List<Integer>> sortedArrayFuture = executerService.submit(sorter);
		
		List<Integer> sortedArray = sortedArrayFuture.get();
		
		System.out.println(sortedArray);
		
		executerService.shutdown();
	}

}
