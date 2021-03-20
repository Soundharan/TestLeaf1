package learnautomation;

public class RemoveDuplicates {

	public static void main(String[] args) {
		String text = "We learn java basics as part of java sessions in java week1";	
		int count=0;
		String[] words = text.split(" ");
		for(int i=0;i<words.length;i++)    //Outer loop for Comparison and to check if sentence is empty or not    
	    {
	      if(words[i]!=null)
	      {
	      
	      for(int j=i+1;j<words.length;j++)          //Inner loop to compare two words in a sentence to check for duplicacy
	      {
	        
	      if(words[i].equals(words[j]))          //Checking if both the compared strings are equal
	        {
	          words[j]=null;      //Deletes the duplicate words if the compared strings are equal
	        }
	      }
	      }
	    }
	    for(int k=0;k<words.length;k++)    //Displaying the String without the duplicate words  
	    {
	      if(words[k]!=null)
	      {
	        System.out.print(words[k] + " ");
	      }
			
		}
		

	}

}
