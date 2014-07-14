package drivers.chapter1;

import java.util.Arrays;
import java.util.Random;

//Write an method such that if an element in an M x N matrix is 0, then
// all elements in that row and column are also set to 0

public class Problem_1_7 {
	
	public static void printMatrix(int[][] matrix){
		int m = matrix.length;
		int n = matrix[0].length;
		StringBuffer line = new StringBuffer(n);
		char separator = '|';
		for (int x = 0; x < m ; x++){
			for (int y=0; y < n; y++){
				line.append(matrix[x][y]);
				if (y < n-1)
					line.append(separator);
			}
			System.out.println(line);
			line = new StringBuffer(n);
		}
	}
	
	//create a an M x N matrix filled with random 0-9 ints. 
	public static int[][] createMatrix(int m, int n){
		Random random = new Random(System.currentTimeMillis());
		int[][] matrix = new int[m][n];
		for (int x=0; x<m; x++){
			for(int y=0; y<n; y++){
				int value = Math.abs(random.nextInt() % 10);
				matrix[x][y] = value;
			}
		}
		return matrix;
	}
	
	//apply zeros to rows and columns in the matrix
	public static int[][] zeroMatrix(int[][] mtx){
		int m = mtx.length;
		int n = mtx[0].length;
		int[][] outMtx = mtx;
		boolean[] rowZero = new boolean[m];
		boolean[] colZero = new boolean[n];
		Arrays.fill(rowZero, false);
		Arrays.fill(colZero, false);
		// find the rows and columns that need to be zeroed 
		for (int x=0; x<m; x++){
			for(int y=0; y<n; y++){
				if (mtx[x][y] == 0){
					rowZero[x] = true;
					colZero[y] = true;
				}
			}
		}

		for (int x=0; x<m; x++){
			for(int y=0; y<n; y++){
				if (rowZero[x] || colZero[y]){
					outMtx[x][y] = 0;
				}
			}
		}
		return outMtx;
	}

	public static void main(String[] args) {
		if (args.length < 2){
			System.out.println("Requires two numbers M and N for an M x N matrix");
			System.exit(0);
		}
		int m = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);
		int[][] matrix = createMatrix(m,n);
		printMatrix(matrix);
		System.out.println("--------------------------------------------");
		int[][] zeroMtx = zeroMatrix(matrix);
		printMatrix(zeroMtx);
	}
}
