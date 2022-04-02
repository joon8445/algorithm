import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int T = 0; T < t; T++) {
			int n = sc.nextInt();
			int[][] field = new int[n][n];
			char[][] tmp = new char[n][n];
			int sum=0;
			for (int i = 0; i < n; i++) {
				 tmp[i] = sc.next().toCharArray();
				 for(int j=0;j<n;j++) {
					 field[i][j]= (int)tmp[i][j]-'0';
				 }
			}
			int blank = n/2;
			for(int i=0;i<n/2;i++,blank--) {
				for(int j=blank;j<n-blank;j++) {
					sum+=field[i][j];
				}
			}
			for(int i=n/2;i<n;i++,blank++) {
				for(int j=blank;j<n-blank;j++) {
					sum+=field[i][j];
				}
			}
			System.out.printf("#%d %d\n",T+1,sum);
		}
		sc.close();
	}
}
