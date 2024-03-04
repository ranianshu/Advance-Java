package AdvanceJava.StreamsAndLambdas.Lambda;

public class Client {

	public static void main(String[] args) {
		
		Runnable r = () -> {
			System.out.println("Hi I am printing");
		};
		
		Thread t = new Thread(r);
		t.start();
		
		Thread t1 = new Thread(()->System.out.print("Hi Printing from lambda"));
		t1.start();
		
	

	}

}
