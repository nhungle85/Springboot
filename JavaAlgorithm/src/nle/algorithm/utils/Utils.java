package nle.algorithm.utils;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Utils {
	public static void printArrays(ArrayList<Integer> numbers) {
		if (numbers != null) {
			
			System.out.println(numbers.stream().map(Object:: toString)
												.collect(Collectors.joining(", ")));
		}
	}
}
