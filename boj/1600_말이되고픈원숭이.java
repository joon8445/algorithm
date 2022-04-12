import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int W, H,K;
	static int[] dx = {-1, 0, 1, 0, -2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dy = {0, 1, 0, -1, 1, 2, 2, 1, -1, -2, -2, -1};
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve();
		System.out.println(ans);
	}

	static void solve() {
		simul(new boolean[H][W][K+1]);
	}

	static void simul(boolean[][][] isSelected) {
		isSelected[0][0][0]=true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0,0,0});
		while(!q.isEmpty()) {
			int[] point = q.poll();
			int x = point[0];
			int y = point[1];
			int k = point[2];
			int cnt = point[3];
			if(x==W-1&&y==H-1) {
				ans = Math.min(ans, cnt);
				return ;
			}
			for(int i=0;i<12;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx<0||nx>=W||ny<0||ny>=H) continue;
				if(i<4) {
					if(isSelected[ny][nx][k]) continue;
					if(map[ny][nx]==0) {
						isSelected[ny][nx][k] =true;
						q.add(new int[] {nx,ny,k,cnt+1});
					}
				}
				else if(k<K) {
					if(isSelected[ny][nx][k+1]) continue;
					if(map[ny][nx]==0) {
						isSelected[ny][nx][k+1] =true;
						q.add(new int[] {nx,ny,k+1,cnt+1});
					}
				}
			}
		}
		ans = -1;
	}
}
