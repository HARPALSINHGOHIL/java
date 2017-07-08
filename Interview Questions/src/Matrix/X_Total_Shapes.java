/**
Given N * M string array of O's and X's
Return the number of 'X' total shapes. 'X' shape consists of one or more adjacent X's (diagonals not included).

Example (1):

OOOXOOO
OXXXXXO
OXOOOXO

answer is 1 , shapes are  :
(i)     X
    X X X X
    X     X
 

Example (2):

XXX
OOO
XXX

answer is 2, shapes are
(i)  XXX

(ii) XXX

Input:
The first line of input takes the number of test cases, T.
Then T test cases follow. Each of the T test cases takes 2 input lines.
The first line of each test case have two integers N and M.The second line of N space separated strings follow which indicate the elements in the array.

Output:

Print number of shapes.

Constraints:

1<=T<=100

1<=N,M<=50

Example:

Input:
2
4 7
OOOOXXO OXOXOOX XXXXOXO OXXXOOO
10 3
XXO OOX OXO OOO XOX XOX OXO XXO XXX OOO

Output:
4
6

 * 
 */
package Matrix;

import java.util.Scanner;

/**
 * @author Harpalsinh
 *
 */
public class X_Total_Shapes {

	
	public static void adjecents(char mat[][],int i,int j,int imax,int jmax) {
		
		mat[i][j]='O';
		if(i+1<imax && mat[i+1][j]=='X')
			adjecents(mat, i+1, j,imax,jmax);
		if(i>0&&mat[i-1][j]=='X')
			adjecents(mat, i-1, j,imax,jmax);
		if(j+1<jmax&&mat[i][j+1]=='X')
			adjecents(mat, i, j+1,imax,jmax);
		if(j>0&&mat[i][j-1]=='X')
			adjecents(mat, i, j-1,imax,jmax);
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for (int tt = 1; tt <= test_case; tt++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			char mat[][] = new char[n][m];
			for(int i=0;i<n;i++)
				mat[i]=sc.next().toCharArray();
			
			int count=0;
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<m;j++)
				{
					if(mat[i][j]=='X')
					{
						count++;
						adjecents(mat,i,j,n,m);
					}
				}
			}
			//System.out.println("Number of X's Shape : "+count);
			System.out.println(count);
		}
		
		sc.close();
	}
	

}
