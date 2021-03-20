package learnautomation;

public class ChangeOddIndexToUpperCase {


	
    public static void main(String s[])
    {
        String testString = "changeme";
        String output = "";
      char[] word = testString.toCharArray();
        for (int i = 0; i < testString.length(); i++) {
            if(i%2 == 0)
            {
            	output += Character.toLowerCase(word[i]);
            }else
            {
                output += Character.toLowerCase(word[i]);
            }
        }

        System.out.println("Newly generated string is as follow: "+ output);
    }
}




