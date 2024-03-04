package AdvanceJava.Generics;

import java.util.HashMap;
import java.util.List;

public class Client {

	public static void main(String[] args) {
		
		HashMap<Integer, String> hm = new HashMap<>();
		hm.put(1, "Anshu");
		hm.put(2, "Ujjwal");
		
		HashMap hm1 = new HashMap();
		hm1.put(1, "Anshu");
		hm1.put("Anshu", 1);
		/*
		 * for(var v: hm1.keySet()) { int i = (int)v; System.out.println(i); //Will give
		 * exception at runtime }
		 */
		
		Utilities.doSomething("Anshu", "Rani");
		Utilities.doSomething(1, "Anshu");
		
		int val = Utilities.getKey(2, "Ujjwal");
		System.out.println("val: " + val);
		
		String val2 = Utilities.getKey("Apple", "mango");
		System.out.println("val2: " + val2);
		
		
		Dog d1 = new Dog();
		d1.name = "Shih tzu";
		
		Dog d2 = new Dog();
		d2.name = "Labra";
		
		List<Dog> animals = List.of(d1,d2);
		printAnimals(animals); //WOrk after we change List<T> in printAnimals() function
		//printAnimals(animals); // Generics of List will not work here
		
		List<String> a2 = List.of("abc", "def");
		//printAnimals(a2); //will not show any error during compile but will throw ClassCastException at runtime
		                  // To solve this we use <T extends Animal>
		
		
		/*
		 * List<Animal> animals2 = List.of(d1,d2); printAnimals(animals2);
		 */

	}
	
	public static <T extends Animal> void printAnimals(List<T> animals) {
		for(var animal: animals) {
			Animal obj = (Animal)animal;
			System.out.println(obj.name);
		}
	}

}
