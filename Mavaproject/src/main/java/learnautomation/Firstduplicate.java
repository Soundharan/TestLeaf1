package learnautomation;

import java.util.Arrays;

public class Firstduplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[] numbers = {2,5,3,7,7,1};
Arrays.sort(numbers);
for (int i = 0; i < numbers.length; i++) {
	if (numbers[i]==numbers[i+1]) {
		System.out.println("The duplicate number is "+numbers[i]);
		break;
		
	}
	
}

	}

}
