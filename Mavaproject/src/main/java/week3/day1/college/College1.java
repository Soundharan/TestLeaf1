package org.college;

public class College1 extends University {

	
	@Override
	public void ug() {
		System.out.println("UG :BSC- COMPUTER SCIENCE");
		
	}
	
public static void main(String[] args) {
		College1 Deg = new College1();
		Deg.pg();
		Deg.ug();
		

	}

	
}
