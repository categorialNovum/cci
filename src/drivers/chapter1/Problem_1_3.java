package drivers.chapter1;

import java.util.Arrays;

// Given 2 strings, determine if one is a permutation of the other


public class Problem_1_3 {
	
	public static void printCharArray(String[] chars){
		StringBuilder sb = new StringBuilder(chars.length);
		for (String c : chars){
			sb.append(c);
		}
		System.out.println(sb.toString());
	}

	//are two strings permutations of each other?
	public static boolean isStringPermutation(String a, String b){
		if (a.length() != b.length()){
			return false;
		}
		if (a.equals(b)){
			System.out.println("Same strings passed in. Returning true");
			return true;
		}
		char[] achars = a.toCharArray();
		char[] bchars = b.toCharArray();
		Arrays.sort(achars);
		Arrays.sort(bchars);
		return Arrays.equals(achars, bchars);
	}

	public static void main(String[] args) {
		if (args.length < 2){
			System.out.println("Two strings required as arguments. Exiting");
			System.exit(0);
		}
		String s1 = args[0];
		String s2 = args[1];
		isStringPermutation(s1, s2);
	}
}
