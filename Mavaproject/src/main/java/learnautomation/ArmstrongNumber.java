package learnautomation;

public class ArmstrongNumber {

	public static void main(String[] args) {

		int a;
		int n = 153;
		int b=0;
		int temp;
		temp=n;
		while (n>0) {
			a=n%10;
			n=n/10;
			b=b +(a*a*a);	
		}
		if (temp==b) {
			System.out.println("The Given number is ArmstrongNumber");

		} else {
			System.out.println("The given number is not a ArmstrongNumber");
		}

	}

}
