package assignment;

public class ArmstrongNumber {


	public static void main(String[] args) {

		int input=153;
		int  a,b =0,temp;
		temp = input;
		while (input>0) {
			a=input%10;
			input=input/10;
			b=b+(a*a*a);
		}

		if (temp==b) {
			System.out.println("The Given number is ArmstrongNumber");

		} else {
			System.out.println("The given number is not a ArmstrongNumber");
		}

	}
}


