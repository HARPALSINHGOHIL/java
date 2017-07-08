/*
Given a matrix with 0’s and 1’s , you enter the matrix at cell (0,0) in left to right direction. whenever you encounter a 0 you retain in same direction , if you encounter a 1’s you have to change direction to right of current direction and change that 1 value to 0, you have to find out from which index you will leave the matrix at the end.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains two lines . The first line of each test case contains two integers n and m denoting the size of the matrix. Then in the next line are n*m space separated values of the matrix.

Output:
For each test case print in a new line two integers separated by space denoting the index of the matrix from which you will leave the matrix at the end.

Constraints:
1<=T<=100
1<=n,m<=20

Example:
Input:
2
3 3
0 0 1 0 0 0 0 0 0
2 4
0 0 0 1 0 0 1 1
Output:
2 2 
0 2
 
 
 */

package Matrix;

import java.util.Scanner;

public class Exit_Point {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for (int tt = 1; tt <= test_case; tt++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int mat[][] = new int[n][m];

			int dir_n = 0;
			int dir_m = 1;
			int curr_n = 0;
			int curr_m = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					mat[i][j] = sc.nextInt();
				}
			}
			do {
				if (mat[curr_n][curr_m] == 1) {
					mat[curr_n][curr_m] = 0;
					if (dir_m == 1 && dir_n == 0) {
						dir_m = 0;
						dir_n = 1;
					} else if (dir_m == 0 && dir_n == 1) {
						dir_m = -1;
						dir_n = 0;
					} else if (dir_m == -1 && dir_n == 0) {
						dir_m = 0;
						dir_n = -1;
					} else {
						dir_m = 1;
						dir_n = 0;
					}
				}
				curr_n += dir_n;
				curr_m += dir_m;

			} while ((curr_n >= 0 && curr_n < n) && (curr_m >= 0 && curr_m < m));
			curr_n -= dir_n;
			curr_m -= dir_m;

			System.out.println(curr_n + " " + curr_m);

		}
		
		sc.close();
	}
}
