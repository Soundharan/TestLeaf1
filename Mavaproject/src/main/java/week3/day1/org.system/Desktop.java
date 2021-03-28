package org.system;

public class Desktop extends Computer {
	
	public void Desktopsize() {
		System.out.println("The size of Desktop is 21inch");
		
	}

	public static void main(String[] args) {
		Desktop assemble = new Desktop();
		assemble.computerModel();
		assemble.Desktopsize();

	}

}
