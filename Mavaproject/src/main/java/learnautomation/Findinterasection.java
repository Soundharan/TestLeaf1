package learnautomation;

public class Findinterasection {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[] array = {3,2,11,4,6,7};
int[] array1 = {1,2,8,4,9,7};
for (int i = 0; i < array.length; i++) {
	for (int j = 0; j < array1.length; j++) {
		if (array[i] == array1[j]) {
			System.out.println("The Intersection number is"+array[i]);
			return;
		}
		
	}
	
}

			
			
			
		}
	
	
}
	


