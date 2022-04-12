import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] cheese;
	static int cnt =0,cheese_now=0,N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cheese = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				int tmp=Integer.parseInt(st.nextToken());
				cheese[i][j]=tmp;
				cheese_now+=tmp;
			}
		}
		solve();
	}
	static void solve() {
		int cheese_pre=0;
		while(cheese_now>0)	{
			air(0,0,new boolean[N][M]);
			cheese_pre = melt();
			cnt++;
		}
		System.out.println(cnt);
		System.out.println(cheese_pre);
	}
	private static int melt() {
		int sum=0;
		for(int i=1;i<N;i++) {
			for(int j=1;j<M;j++) {
				if(cheese[i][j]==2) {
					cheese[i][j]=0;
					sum++;
				}
			}
		}
		cheese_now-=sum;
		return sum;
	}
	static void air(int i,int j,boolean[][] isSelected) {
		if(!isSelected[i][j]&&cheese[i][j]==0) {
			isSelected[i][j]=true;
			if(i+1<N) air(i+1,j,isSelected);
			if(i-1>0) air(i-1,j,isSelected);
			if(j+1<M) air(i,j+1,isSelected);
			if(j-1>0) air(i,j-1,isSelected);
		}
		if(cheese[i][j]==1)cheese[i][j]=2;
		return;
	}
}
