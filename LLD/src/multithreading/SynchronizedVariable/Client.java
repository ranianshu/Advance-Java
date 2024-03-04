package multithreading.SynchronizedVariable;

public class Client {

	public static void main(String[] args) throws InterruptedException {
	
		Count count = new Count();
		Adder adder = new Adder(count);
		Substractor substractor = new Substractor(count);

		Thread t1 = new Thread(adder);
		t1.start();
		
		Thread t2 = new Thread(substractor);
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(count.val);
		
	}

}
