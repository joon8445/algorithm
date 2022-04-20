import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R,C,M,ans=0;
	static int[] dx = {0,-1,1,0,0};
	static int[] dy = {0,0,0,1,-1};
	static Shark[] sharks; 
	static int[][] map;
	static class Shark {
		int x,y,speed,dir,size;
		
		public Shark(int x, int y, int speed, int dir, int size) {
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sharks = new Shark[M+1];
		map = new int[R+1][C+1];
		for(int i=1;i<=M;i++) {
			st =new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			sharks[i] = new Shark(r,c,s,d,z);
			map[r][c] = i;
		}
		ans=0;
		for(int i=1;i<=C;i++) {
			solve(i);
		}
		System.out.println(ans);
	}
	
	private static void solve(int fisher) {
		fish(fisher);
		for(int i=1;i<=M;i++) {
			if(sharks[i]==null)continue;
			move(sharks[i]);
		}
		eat();
	}
	
	static void eat() {
		int newMap[][]= new int[R+1][C+1];
		for(int i=1;i<=M;i++) {
			if(sharks[i]==null)continue;
			int x = sharks[i].x;
			int y = sharks[i].y;
			
			if(newMap[x][y]!=0) {
				int pre = newMap[x][y];
				int preSize = sharks[pre].size;
				int curSize = sharks[i].size;
				if(preSize<curSize) {
					newMap[x][y]=i;
					sharks[pre]=null;
				}else {
					sharks[i]=null;
				}
			}else {
				newMap[x][y]=i;
			}
		}
		map = newMap;
	}
	
	static void fish(int fisher) {
		for(int i=1;i<=R;i++) {
			if(map[i][fisher]!=0) {
				int idx = map[i][fisher];
				ans+=sharks[idx].size;
				sharks[idx]=null;
				map[i][fisher]=0;
				return;
			}
		}
	}
	
	static void move(Shark shark) {
		int s = shark.speed;
		int x = shark.x;
		int y = shark.y;
		for(int i=0;i<s;i++) {
			int nx = x + dx[shark.dir];
			int ny = y + dy[shark.dir];
			if(nx<1||nx>R||ny<1||ny>C) {
				shark.dir = shark.dir%2==0 ? shark.dir-1:shark.dir+1;
				nx = x + dx[shark.dir];
				ny = y + dy[shark.dir];
			}
			x=nx;
			y=ny;
		}
		shark.x = x;
		shark.y = y;
	}
}
