package learnautomation;

public class Sumexample {

	static int getsum(int n) 
	{
		int sum = 0;

		while (n!=0) {
			sum = sum + n%10;
			n=n/10;

		}
		return sum;

	}

	public static void main(String[] args) {

		int n=123;
		System.out.println(getsum(n));
	}

}
