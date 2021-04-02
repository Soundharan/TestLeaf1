package week3.day2;


import java.util.LinkedHashSet;
import java.util.Set;


public class RemoveDuplicates {



	public static void main(String[] args) {
String name = "PayPal India" ;
name = name.replaceAll(" ", "");
char[] charArray = name.toCharArray();
Set<Character> charSet = new LinkedHashSet<Character>();
Set<Character> dupCharSet = new LinkedHashSet<Character>();

for (int i = 0; i < charArray.length; i++) {
	if (!charSet.add(charArray[i])) {
		dupCharSet.add(charArray[i]);
	}

}
	System.out.println(charSet);
	System.out.println(dupCharSet);
	
for (Character character : charSet) {
		System.out.print(character);
	}

	
}
	}


