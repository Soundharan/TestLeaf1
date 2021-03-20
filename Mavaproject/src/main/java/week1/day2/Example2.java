package week1.day2;


import java.util.Arrays;

public class Example2 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[] numbers= {2,5,3,7,7,1};
Arrays.sort(numbers);
System.out.println(Arrays.toString(numbers));
for (int i = 0; i < numbers.length; i++) {
	if(numbers[i]==numbers[i+1]) {
		System.out.println("The Duplicate number is " +numbers[i]);
		break;
		
	
}
	
	
}


	}

}
