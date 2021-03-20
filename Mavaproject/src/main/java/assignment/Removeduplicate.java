package assignment;

public class Removeduplicate {

	public static void main(String[] args) {
		String text = "We learn java basics as part of java sessions in java week1";
		System.out.println(text);
		String[] words = text.split(" ");
		for(int i=0;i<words.length;i++)        
		{
			if(words[i]!=null)
			{

				for(int j=i+1;j<words.length;j++)           
				{

					if(words[i].equals(words[j])) 
					{
						words[j]=null;      
					}
				}
			}
		}
		for(int k=0;k<words.length;k++)   
		{
			if(words[k]!=null)
			{
				System.out.print(words[k] + " ");
			}


		}
	}
}
