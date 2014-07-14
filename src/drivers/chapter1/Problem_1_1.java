package drivers.chapter1;
import java.util.HashMap;

//Implement an algorithm to determine if a string is comprised entirely of unique characters

public class Problem_1_1 {
	
	public static boolean isUniqueNoDS(String s){
		
		return true;
	}
	
	// Determine if the characters are unique, no restrictions
	public static boolean hasUniqueChars(String s){
		String chars[] = s.split("");
		HashMap <String, Integer> charCount = new HashMap<String, Integer>();
		
		for (String c : chars){
			Integer count = charCount.get(c);
			if (count == null){
				charCount.put(c, 1);
			}else{
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		if (args.length < 1){
			System.out.println("An input argument is required. Exiting.");
			System.exit(0);
		}
		
		for (String str : args){
			if (hasUniqueChars(str)){
				System.out.println(str + " is unique!");
			}else{
				System.out.println(str + " is NOT a special snowflake.");
			}
		}
	}
}
