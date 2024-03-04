package AdvanceJava.Collections;

import java.util.ArrayList;
import java.util.Collections;

public class Client {
	
	public static void main(String[] args) {
		
		ArrayList<Student> list = new ArrayList<>();
		
		list.add(new Student("Ujjwal",25,6));
		list.add(new Student("Anshu",27,3));
		list.add(new Student("Sagarika",28,1));
		
		Collections.sort(list);
		System.out.println(list);
		
		Collections.sort(list, new StudentAgeComparator());
		System.out.println(list);
	}
	
	
	
	

}
