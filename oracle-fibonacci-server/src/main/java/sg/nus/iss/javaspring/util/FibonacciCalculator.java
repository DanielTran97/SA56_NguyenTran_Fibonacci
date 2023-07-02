package sg.nus.iss.javaspring.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import sg.nus.iss.javaspring.model.FibonacciResponse;

public class FibonacciCalculator {
	
	public static FibonacciResponse getFibonacci(Integer integer) {
		Stack<Integer> oddNum = new Stack<>();
		Stack<Integer> evenNum = new Stack<>();
		List<Integer> FibonacciSequence = new ArrayList<>();
		
		Integer currentNum = 1;
		Integer currentNum1 = 0;
		
		FibonacciSequence.add(0);
		evenNum.add(0);
		
		//Fibonacci rule: the next number in an array is calculated by adding the two previous number. 
		for(int i = 1; i < integer; i++) {
			FibonacciSequence.add(currentNum);
			if(currentNum % 2 != 0) {
				oddNum.add(currentNum);
			}
			else if(currentNum % 2 == 0) {
				evenNum.add(currentNum);
			}
			
			Integer tempNum = currentNum1;
			currentNum1 = currentNum;
			currentNum = currentNum1 + tempNum;
		}
		return new FibonacciResponse(FibonacciSequence, mergeList(oddNum, evenNum));
	}

	private static List<Integer> mergeList(Stack<Integer> oddNum, Stack<Integer> evenNum) {
		List<Integer> merged = new ArrayList<>();
		while (!evenNum.isEmpty()) {
			merged.add(evenNum.pop());
		}
		while (!oddNum.isEmpty()) {
			merged.add(oddNum.pop());
		}
		return merged;
	}
}
