package AdvanceJava.StreamsAndLambdas.Streams;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Client {
	
	public static void main(String[] args) {
		
		List<Integer> list = List.of(1,2,3,4,5,6);
		
		Stream<Integer> stream = list.stream();
		
		List<Integer> ans = stream.filter((ele) -> ele % 2 == 0)
				.collect(Collectors.toList());
		
		System.out.println("filter ans: " + ans);
		
		stream = list.stream();
		List<Integer> ans2 = stream.filter((ele) -> ele % 2 == 0)
				.sorted()
				.map((ele) -> ele * 10)
				.collect(Collectors.toList());
		
		System.out.println("map ans2: " + ans2);
		
		stream = list.stream();
		Optional<Integer> first = stream.filter((ele) -> ele % 2 == 0)
				.sorted()
				.map((ele) -> ele * 10)
				.findFirst();
		System.out.println("first: "+ first.get());
		
		stream = list.stream();
		int sum = stream.reduce(0, (num1, num2) -> num1 + num2);
		System.out.println("sum: " + sum);
		
		stream = list.stream();
		int max = stream.reduce(Integer.MIN_VALUE, (curr_max, ele) -> {
			                              return Math.max(curr_max, ele);
		});
		System.out.println("max: " + max);
		
		//Intermediate Operations -> filter(), map(), sorted()
		//Terminal Operations -> collect(), findFirst() reduce()
	}
}
