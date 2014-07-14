package drivers.chapter1;
//Compress a string when consecutive characters are repeated
// 'aaabbbccccaa' becomes 'a3b3c3a2'
// return the original string if the encoded string is longer
public class Problem_1_5 {
	
	public static int chancesToReduce(char[] str){
		// valid input includes only upper and lower case letters. 
		// initialize the place holder chars to  different values outside of that set.
		char curChar = '!';
		char aChar = '@';
		char bChar = '%';
		int compNum = 0;
		
		for (char c : str){
			bChar = aChar;
			aChar = curChar;
			curChar = c;
			//every time 3 consecutive chars appear, its an opportunity for compression
			if (bChar == aChar && aChar == curChar){
				compNum++;
			}
			// Single char identified. the compression encoding will increase size. IE. a -> a1
			else if (bChar != aChar && aChar != curChar){
				compNum--;
			}
		}
		return compNum;
	}
	
	public static String convert(char[] str){
		char[] out = new char[str.length];
		char current = '$';
		char prev = '#';
		int n = 1;
		int idx = 0;
		
		for (int c = 0; c < str.length; c++){
			prev = current;
			current = str[c];
			System.out.println("P / C " + c + " : "  + prev + " / " + current);
			if (current == prev){
				n++;
				if (c == str.length - 1){
					out[idx++] = current;
					out[idx++] = Character.forDigit(n, 10);
				}
			}
			else if (current != prev && c > 0){
				out[idx++] = prev;
				out[idx++] = Character.forDigit(n, 10);
				System.out.println("Nchar : " + Character.forDigit(n,10));
				n = 1;
			}
		}
		return new String(out);
	}

	public static String compress(String s){
		char[] str = s.toCharArray();
		int compFactor = chancesToReduce(str);
		if (compFactor > 0){
			System.out.println("CF : " + compFactor);
			return convert(str);
		}
		return s;
	}
	
	public static void main(String[] args) {
		for (String s : args){
			System.out.println(s + " : " + compress(s));
		}
		System.out.println("Done.");
	}
}
