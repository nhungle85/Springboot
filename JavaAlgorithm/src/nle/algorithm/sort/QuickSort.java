package nle.algorithm.sort;

import java.util.ArrayList;
import java.util.Random;

import nle.algorithm.utils.Utils;

public class QuickSort {

	public static void main(String[] args) {
		Random randN = new Random();
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			numbers.add(randN.nextInt(100));
		}

		System.out.println("Before quick sort: ");
		Utils.printArrays(numbers);

		numbers = quickSort(numbers);

		System.out.println("After quick sort: ");
		Utils.printArrays(numbers);

	}

	public static ArrayList<Integer> quickSort(ArrayList<Integer> numbers) {
		if (numbers.size() <= 1)
			return numbers;

		ArrayList<Integer> lefts = new ArrayList<Integer>();
		ArrayList<Integer> rights = new ArrayList<Integer>();
		
		int lastNumber = numbers.remove(numbers.size() - 1);
		
		for (Integer n : numbers) {
			if (n <= lastNumber)
				lefts.add(n);
			else 
				rights.add(n);
		}
		
		
		if (lefts.size() > 0) {
			lefts = quickSort(lefts);
		}

		
		if (rights.size() > 0) {
			rights = quickSort(rights);
		}
		
		lefts.add(lastNumber);
		lefts.addAll(rights);
		
		return lefts;
	}

}
