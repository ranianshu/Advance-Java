package multithreading.AdderSubstractor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

	public static void main(String[] args) throws InterruptedException {
	
		Count count = new Count();
		Adder adder = new Adder(count);
		Substractor substractor = new Substractor(count);
		
		/*
		 * ExecutorService executorService = Executors.newCachedThreadPool();
		 * executorService.execute(adder); executorService.execute(substractor);
		 * 
		 * System.out.println(count.val);
		 * 
		 * executorService.shutdown();
		 */

		Thread t1 = new Thread(adder);
		t1.start();
		
		Thread t2 = new Thread(substractor);
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(count.val);
		
	}

}
