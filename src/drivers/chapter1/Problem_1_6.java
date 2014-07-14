package drivers.chapter1;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;

//given an image represented by an NxN matrix, where each pixel is 4 bytes
//write a method to rotate the image 90 degrees. Can this be done in place?
public class Problem_1_6 {
	
	public static int[][] createImage(int n){
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		int[][] i = new int[n][n];
		for (int num = 0; num < n*n; num++){
			numbers.add(num);
		}
		Iterator<Integer> nItr = numbers.iterator();
		for (int row = 0; row < n; row++){
			for(int col = 0; col < n; col++){
				i[row][col] = nItr.next();
			}
		}
		return i;
	}
	
	public static String pad(int num, int n){
		int maxLen = Integer.toString(n*n).length();
		int curLen = Integer.toString(num).length();
		int nZeros = maxLen - curLen;
		String pad = "";
		for (int x=0; x < nZeros; x++){
			pad += "0";
		}
		return pad + Integer.toString(num);
	}
	
	public static void printImage(int[][] img){
		int n = img.length;
		StringBuffer line = new StringBuffer(n);
		char separator = '|';
		for (int x = 0; x < n ; x++){
			for (int y=0; y < n; y++){
				line.append(pad(img[x][y],n));
				if (y < n-1)
					line.append(separator);
			}
			System.out.println(line);
			line = new StringBuffer(n);
		}
	}
	
	public static int[][] rotateLeft(int[][] img){
		int n = img.length;
		int[][] out = new int[n][n];
		for (int x = 0; x < n ; x++){
			for (int y=0; y < n; y++){
				out[y][x] = img[x][y];
			}
		}
		return out;
	}

	public static void rotateRight(int[][] img){
		int n = img.length;
		for (int layer =0; layer < n/2; layer++){
			int start = layer;
			int finish = n - 1 - layer;
			for(int i = start; i < finish; i++){
				int offset = i - start; 
				int top =  img[start][i];
				// left -> top
				img[start][i] = img[finish-offset][start];
				// bottom -> left
				img[finish-offset][start] = img[finish][finish-offset];
				// right -> bottom 
				img[finish][finish-offset] = img[i][finish];
				// top -> right
				img[i][finish] = top;
			}
		}
	}

	public static void main(String[] args) {
		if (args.length == 0){
			System.out.println("Requires a size N");
			System.exit(0);
		}
		int n = Integer.parseInt(args[0]);
		int[][] image = createImage(n);
		printImage(image);
		System.out.println("-----------------");
		int[][] rLeft = rotateLeft(image);
		rotateRight(image);
		printImage(image);
	}

}
