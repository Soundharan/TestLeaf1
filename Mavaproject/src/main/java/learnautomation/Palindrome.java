package learnautomation;


public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String name="tenet";
String name1="";
char[] charArray = name.toCharArray();
for (int i = charArray.length-1; i>=0 ; i--) {
name1 = name1 + charArray[i];
}
System.out.println(name1);
	if (name.equals(name1)) {
		System.out.println("The Given Number is Palindrome");
		}
		else{
			System.out.println("The Given Number is not Palindrome");
		}
		
	}
	
}
	



