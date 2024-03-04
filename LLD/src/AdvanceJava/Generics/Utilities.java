package AdvanceJava.Generics;

public class Utilities {
	
	public static <K,V> void doSomething(K key, V value) {
		System.out.println("key: " + key);
		System.out.println("value: " + value);
	}
	
	public static <K,V> K getKey(K key, V value) {
		return key;
	}

}
