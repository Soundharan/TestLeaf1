package week3.day2;
	// Java prorgam to count frequencies of
	// characters in string using LinkedHashMap
	import java.util.*;
	class OccurenceOfCharInString {
		static void characterCount(String inputString)
		{
			// Creating a HashMap containing char
			// as a key and occurrences as a value
			HashMap<Character, Integer> charCountMap
				= new LinkedHashMap<Character, Integer>();
			String replaceAll = inputString.replaceAll(" ", "");
			// Converting given string to char array

			char[] strArray = replaceAll.toCharArray();

			// checking each char of strArray
			for (char c : strArray) {
				if (charCountMap.containsKey(c)) {

					// If char is present in charCountMap,
					// incrementing it's count by 1
					charCountMap.put(c, charCountMap.get(c) + 1);
				}
				else {

					// If char is not present in charCountMap,
					// putting this char to charCountMap with 1 as it's value
					charCountMap.put(c, 1);
				}
			}

			// Printing the charCountMap
			for (Map.Entry entry : charCountMap.entrySet()) {
				System.out.println(entry.getKey() + " " + entry.getValue());
			}
		}

		// Driver Code
		public static void main(String[] args)
		{
			String str = "welcome to Selenium automation";
			characterCount(str);
		}
	}
