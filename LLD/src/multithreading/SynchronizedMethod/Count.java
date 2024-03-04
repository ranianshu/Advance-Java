package multithreading.SynchronizedMethod;

public class Count {
	
	 int value;
	 
	 synchronized void incrementValue(int offset) {
		 value += offset;
	 }
	 
	 int getValue() {
		 return value;
	 }

}
