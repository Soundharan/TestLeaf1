package assignment;

public class Reverseanevenword {
	public static void main(String[] args) {
		String test="i am a software engineer";
		System.out.println(test);
		String[]split=test.split(" ");

		for(int i=0;i<split.length;i++)
		{
			if(i%2==0)
			{
				
		
				{
					System.out.print(" ");
					System.out.print(split[i]);
				}
			}
			
			if(i%2==1)
			
				{
				String rev=split[i];
				System.out.print(" ");	
				char[]reve=rev.toCharArray();
				for(int j=reve.length-1;j>=0;j--)
					
				
					System.out.print(reve[j]);
				}
			}
		}
		
		}
