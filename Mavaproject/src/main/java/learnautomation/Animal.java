package learnautomation;

public class Animal  extends Employee{

	

	String animal_name;
	String animal_type;
	
	public Animal(String name,String type ) {
		animal_name=name;
		animal_type=type;
		System.out.println("Name of the animal is"+animal_name);
		
	}
	public static void main(String[] args) {
		Animal amimal = new Animal("Lion", "yellow");
		
	}

}
