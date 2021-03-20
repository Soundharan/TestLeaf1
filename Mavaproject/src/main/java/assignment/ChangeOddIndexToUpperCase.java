package assignment;

public class ChangeOddIndexToUpperCase {

	public static void main(String[] args) {
		String str= "changeme";
		String str1=str.toUpperCase();
	
		char[]lower=str.toCharArray();
		char[]upper=str1.toCharArray();
		
		
		
		for(int i=0;i<lower.length;i++)
		{
		
			
			if(i%2==0)
			{
			System.out.print(upper[i]);
			}
			else
			{
				System.out.print(lower[i]);
			}
		}

	}

}
