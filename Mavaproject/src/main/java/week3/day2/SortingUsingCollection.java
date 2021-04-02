package week3.day2;

import java.util.Arrays;

public class SortingUsingCollection {

	public static void main(String[] args) {
		String[] input = {"HCL","Wipro","Aspire Systems","CTS"};
		int length = input.length;
		System.out.println(length);
		Arrays.sort(input);  
		//String Sort = Arrays.toString(input);
		System.out.println("Array elements in  order: " +Arrays.toString(input));
		for (int i=input.length-1; i >=0; i--) {
			System.out.println(input[i]);
			
		}
	}

}
