package drivers.chapter1;

// Take a string and replace all spaces with '%20'
// Use a character array when coding in java
public class Problem_1_4 {
	
	public static String replaceSpaces(char[] in){
		int numspaces = 0;
		for (int i=0; i < in.length; i++){
			if (in[i] == ' '){
				numspaces++;
			}
		}

		// replacing each space with '%20' means we will need 2 extra slots for each space in the string
		int outsize = in.length + (numspaces * 2);
		char[] out = new char[outsize];
		int outidx = 0;
		for (int x=0; x<in.length; x++){
			if (in[x] == ' '){
				out[outidx++] = '%';
				out[outidx++] = '2';
				out[outidx++] = '0';
			}else{
				out[outidx++] = in[x];
			}
		}
		
		return new String(out);
	}
	
	public static void main(String[] args) {
		for (String s : args){
			String output = replaceSpaces(s.toCharArray());
			System.out.println(s + " : " + output);
		}
		System.out.println("Done.");
	}
}
