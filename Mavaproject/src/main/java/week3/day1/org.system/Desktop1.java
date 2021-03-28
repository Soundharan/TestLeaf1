package org.system;

public class Desktop1 implements Software {
	
	public void Desktop() {
		System.out.println("Assemble Dell desktop");
		
	}
	public void hardwareResources() {
		System.out.println("Hardware Resource : Intel Core i5 10th Gen");
		
	}

	public void softwareResources() {
		System.out.println("Software : Microsoft Office");
		
	}
	public static void main(String[] args) {
	Desktop1 assemble = new Desktop1();
	assemble.Desktop();
assemble.hardwareResources();
assemble.softwareResources();

}
}
