package assignment;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		String t1="stops";
		String t2="potss";
		char[]c1=t1.toCharArray();
		char[]c2=t2.toCharArray();
		Arrays.sort(c1);
		System.out.println(c1);
		Arrays.sort(c2);
		System.out.println(c2);
		if (t1.length()==t2.length())
				{
			
				
			if(Arrays.equals(c1, c2))
			{
			System.out.println("samevalue");
				}
		
			
		}

	}
	}
