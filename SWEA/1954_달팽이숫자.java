import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			System.out.printf("#%d\n",i+1);
			int n = sc.nextInt();
			int print = n;
			int[][] arr = new int[n][n];
			int col = 0, row = -1, cnt = 0;
			while (n > 0) {
				for (int j = 0; j < n; j++) arr[col][++row] = ++cnt;
				--n;
				for (int j = 0; j < n; j++)	arr[++col][row]= ++cnt;
				for (int j = 0; j < n; j++)	arr[col][--row]= ++cnt;
				--n;
				for (int j = 0; j < n; j++)	arr[--col][row]= ++cnt;	
			}
			for(int j=0;j<print;j++) {
				for(int k=0;k<print;k++) {
					System.out.printf("%d ",arr[j][k]);
				}
				System.out.println();
			}
		}
	}
}

import java.util.Scanner;

public class SWEA1954_달팽이숫자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			System.out.printf("#%d\n",i+1);
			int n = sc.nextInt();
			int print = n;
			int[][] arr = new int[n][n];
			int col = 0, row = -1, cnt = 0;
			while (n > 0) {
				for (int j = 0; j < n; j++) arr[col][++row] = ++cnt;
				--n;
				for (int j = 0; j < n; j++)	arr[++col][row]= ++cnt;
				for (int j = 0; j < n; j++)	arr[col][--row]= ++cnt;
				--n;
				for (int j = 0; j < n; j++)	arr[--col][row]= ++cnt;	
			}
			for(int j=0;j<print;j++) {
				for(int k=0;k<print;k++) {
					System.out.printf("%d ",arr[j][k]);
				}
				System.out.println();
			}
		}
	}
}
