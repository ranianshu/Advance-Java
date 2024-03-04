package AdvanceJava.StreamsAndLambdas.Calculator;

public class Client {
	
	public static void main(String[] args) {
		
		MathOperator addition = (one, two) -> one + two;
		MathOperator substract = (one, two) -> one - two;
		MathOperator multiply = (one, two) -> one * two;
		MathOperator divide = (one, two) -> one / two;
		
		int add = addition.operate(2, 3);
		int sub = substract.operate(5, 3);
		int mul = multiply.operate(2, 3);
		int div = divide.operate(8, 2);
		
		System.out.println(add);
		System.out.println(sub);
		System.out.println(mul);
		System.out.println(div);
	}

}
