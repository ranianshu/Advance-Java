package multithreading.AtomicInteger;

public class Substractor implements Runnable{
	
	private Count count;
	
	public Substractor(Count count) {
		this.count = count;
	}

	@Override
	public void run() {
		for(int i = 1; i <= 10000; i++) {
			count.value.getAndAdd(-i);
		}
		
	}

}
