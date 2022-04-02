import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			int N=sc.nextInt();
			int M=sc.nextInt();
			int[][] fly= new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					fly[i][j]=sc.nextInt();
				}
			}
			int corps=0;
			for(int i=0;i<N-M+1;i++) {
				for(int j=0;j<N-M+1;j++) {
					int sum=0;
					for(int k=i;k<M+i;k++) {
						for(int l=j;l<M+j;l++) {
							sum+=fly[k][l];
						}
					}
					if(corps<sum) corps=sum;
				}
			}
			System.out.printf("#%d %d\n",t+1,corps);
		}
		sc.close();
	}
}
