import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,ans,mapSize,wall[];
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static List<int[]> virus;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		mapSize=N*M;
		wall=new int[3];
		virus = new ArrayList<int[]>();
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][j]= tmp;
				if(tmp == 2) {
					virus.add(new int[] {i,j});
				}
			}
		}
		solve(0,0,map);
		System.out.println(ans);
	}
	
	static void bfs(int[][] map) {
		int size=virus.size();
		for(int i=0;i<size;i++) {
			int[] start = virus.get(i);
			Queue<int[]> q = new ArrayDeque<>();
			q.offer(start);
			while(!q.isEmpty()) {
				int x = q.peek()[0];
				int y = q.poll()[1];
				for(int dir=0;dir<4;dir++) {
					int nx = x+dx[dir];
					int ny = y+dy[dir];
					if(nx<0||ny<0||nx>=N||ny>=M)continue;
					if(map[nx][ny]!=0)continue;
					map[nx][ny]=2;
					q.offer(new int[] {nx,ny});
				}
			}
		}
		int cnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) cnt++;
			}
		}
		ans=Math.max(ans, cnt);
	}
	
	static void solve(int cnt, int cur,int[][] map) {
		if(cnt==3) {
			int x=wall[0]/M,y=wall[0]%M;
			int x1=wall[1]/M,y1=wall[1]%M;
			int x2=wall[2]/M,y2=wall[2]%M;
			if(map[x][y]!=0||map[x1][y1]!=0||map[x2][y2]!=0) return;
			int[][] mapClone = new int[N][M]; 
			for(int i=0;i<N;i++)mapClone[i]=map[i].clone();
			mapClone[x][y]=1;
			mapClone[x1][y1]=1;
			mapClone[x2][y2]=1;
			bfs(mapClone);
			return;
		}
		for(int i=cur;i<mapSize;i++) {
			wall[cnt]=i;
			solve(cnt+1,i+1,map);
		}
	}
}
