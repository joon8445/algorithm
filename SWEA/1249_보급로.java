import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
	static int N;
	static int[][] map,dp;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			dp = new int[N][N];
			for(int i=0;i<N;i++) {
				String str = br.readLine();
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(str.substring(j,j+1));
				}
			}
			int ans = bfs();
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
	static int bfs() {
		int ans =Integer.MAX_VALUE;
		Queue<int[]> q = new ArrayDeque<int[]>();
		boolean visit[][] = new boolean[N][N];
		q.add(new int[] {0,0});
		visit[0][0]=true;
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.poll()[1];
			if(x==N-1&&y==N-1) {
				ans = Math.min(ans, dp[N-1][N-1]);
			}
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx<0||ny<0||nx>=N||ny>=N) continue;
				if(visit[nx][ny]&&dp[nx][ny]<=dp[x][y]+map[nx][ny]) continue;
				visit[nx][ny]= true;
				dp[nx][ny]=dp[x][y]+map[nx][ny];
				q.add(new int[] {nx,ny});
			}
		}
		return ans;
	}
}
