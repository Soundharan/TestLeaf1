package week1.day2;

public class example {

	public static void main(String[] args) {
		
		String company ="Amazon Development Center";
		String[] name = company.split(" ");
		
		for (int i = name.length-1; i >=0; i--) {
		System.out.print(name[i]+ " ");
		
		}
	}
		
		
}
