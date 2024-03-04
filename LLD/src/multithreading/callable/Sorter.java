package multithreading.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>>{
	
	private List<Integer> arrayToSort;
	
	Sorter(List<Integer> arrayToSort){
		this.arrayToSort = arrayToSort;
	}

	@Override
	public List<Integer> call() throws Exception {
		
		System.out.println("used by thread: "+ Thread.currentThread().getName());
		
		//base case
		if(arrayToSort.size() <= 1) {
			return arrayToSort;
		}
		
		//divide into two halves
		int mid = arrayToSort.size()/2;
		
		//Left Array
		List<Integer> leftArray = new ArrayList<>();
		for(int i = 0; i < mid; i++) {
			leftArray.add(arrayToSort.get(i));
		}
		
		//Right Array
		List<Integer> rightArray = new ArrayList<>();
		for(int i = mid; i < arrayToSort.size(); i++) {
			rightArray.add(arrayToSort.get(i));
		}
		
		//sort each half
		Sorter leftSorter = new Sorter(leftArray);
		Sorter rightSorter = new Sorter(rightArray);
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		Future<List<Integer>> leftSortedArrayFuture = executorService.submit(leftSorter);
        Future<List<Integer>> rightSortedArrayFuture = executorService.submit(rightSorter);
		
		/*
		 * List<Integer> leftSortedArray = leftSorter.call(); List<Integer>
		 * rightSortedArray = rightSorter.call();
		 */
        
        List<Integer> leftSortedArray = leftSortedArrayFuture.get();
        List<Integer> rightSortedArray = rightSortedArrayFuture.get();
        
		//merge results
		List<Integer> sortedArray = new ArrayList<>();
		int leftPtr = 0;
		int rightPtr = 0;
		
		while(leftPtr < leftSortedArray.size() && rightPtr < rightSortedArray.size()) {
			if(leftSortedArray.get(leftPtr) < rightSortedArray.get(rightPtr)) {
				sortedArray.add(leftSortedArray.get(leftPtr));
				leftPtr++;
			}
			else {
				sortedArray.add(rightSortedArray.get(rightPtr));
				rightPtr++;
			}
		}
		
		while(leftPtr < leftSortedArray.size()) {
			sortedArray.add(leftSortedArray.get(leftPtr));
			leftPtr++;
		}
		
		while(rightPtr < rightSortedArray.size()) {
			sortedArray.add(rightSortedArray.get(rightPtr));
			rightPtr++;
		}
		
		//return results
		return sortedArray;
	}

}
