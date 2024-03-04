package multithreading.Mutex;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {

	public static void main(String[] args) throws InterruptedException {
	
		Count count = new Count();
		
		
		Lock lock = new ReentrantLock();
		
		Adder adder = new Adder(count, lock);
		Substractor substractor = new Substractor(count, lock);
		
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
