package week3.day2;

import java.util.LinkedHashMap;
import java.util.Map;

public class Maporder {

	public static void main(String[] args) {
		String name="welcome to Selenium automation";
		name=name.replaceAll(" ", "");
		System.out.println("name without white space :" +name);
		char[] namechar = name.toCharArray();
		int length = namechar.length;
		System.out.println("After change to char" + namechar.toString());
		System.out.println(namechar);
		System.out.println(" the length of the cahr is"+length);
		Map<Integer, Character> word= new LinkedHashMap<Integer, Character>();
		for (int i = 0; i < namechar.length; i++) {
				word.put(i+1,namechar[i]);
	
			
		}
				
			System.out.println(word);
			System.out.println(word.get(1));
		}

			
		}


