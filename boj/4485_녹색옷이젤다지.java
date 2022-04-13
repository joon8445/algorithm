import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map, d;
	static int N;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N=Integer.parseInt(br.readLine());
		for(int t=1; N!=0;t++,N=Integer.parseInt(br.readLine())) {
			sb.append("Problem ").append(t).append(": ");
			map = new int[N][N];
			d = new int[N][N];
			for(int i=0;i<N;i++) {
				StringTokenizer st =new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					d[i][j]=Integer.MAX_VALUE;
				}
			}
			d[0][0]=map[0][0];
			solve();
			sb.append(d[N-1][N-1]).append("\n");
		}
		System.out.println(sb.toString());
	}
	static void solve() {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] {0,0});
		while(!q.isEmpty()) {
			int nx,ny;
			int[] arr = q.poll();
			int x = arr[0];
			int y = arr[1];
			for(int i=0;i<4;i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
				if(d[nx][ny]<=d[x][y]+map[nx][ny]) continue;
				d[nx][ny]=d[x][y]+map[nx][ny];
				q.add(new int[] {nx,ny});
			}
		}
	}
}
