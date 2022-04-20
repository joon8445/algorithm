import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Pos point[];
	static boolean[][] map;
	static class Pos{
		int x,y;
		public Pos(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int n = Integer.parseInt(br.readLine());
			N=n+2;
			point = new Pos[N];
			map = new boolean[N][N];
			for(int i=0;i<N;i++) {
				StringTokenizer st =new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				point[i]= new Pos(x,y);
			}
			for(int i=0;i<=n;i++) {
				Pos p1 =point[i];
				for(int j=i+1;j<N;j++) {
					Pos p2 = point[j];
					if(Math.abs(p1.x-p2.x)+Math.abs(p1.y-p2.y)<=1000) {
						map[i][j]=true;
						map[j][i]=true;
					}
				}
			}
			if(solve()) {
				sb.append("happy\n");
			}else {
				sb.append("sad\n");
			}
		}
		System.out.println(sb.toString());
	}
	static boolean solve() {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visit = new boolean[N];
		q.offer(0);
		visit[0]=true;
		while(!q.isEmpty()) {
			int idx = q.poll();
			for(int i=1;i<N;i++) {
				if(map[idx][i]) {
					if(visit[i]) continue;
					if(i==N-1) {
						return true;
					}
					visit[i]=true;
					q.offer(i);
				}
			}
		}
		return false;
	}
}
