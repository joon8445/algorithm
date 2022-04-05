import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,R;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<R;i++) {
			rotation(arr,Math.min(N, M)/2,0);
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void rotation(int[][] arr, int cnt, int dept) {
		if(cnt==0) {
			return;
		}
		int tmp=arr[dept][dept];
		for(int i=dept;i<M-dept-1;i++) arr[dept][i]=arr[dept][i+1];			// 상 <
		for(int i=dept;i<N-dept-1;i++) arr[i][M-dept-1]=arr[i+1][M-dept-1];	// 우 ^
		for(int i=M-dept-1;i>dept;i--) arr[N-dept-1][i]=arr[N-dept-1][i-1];	// 하 >
		for(int i=N-dept-1;i>dept;i--) arr[i][dept]=arr[i-1][dept];			// 좌 v
		arr[dept+1][dept]=tmp;
		rotation(arr,cnt-1,dept+1);
		
	}
}
