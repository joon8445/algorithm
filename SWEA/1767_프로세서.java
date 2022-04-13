import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static class Core{
		int i,j;
		public Core(int i,int j) {
			this.i=i;
			this.j=j;
		}
	}
	static int N,map[][],ans,core;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static List<Core> coreList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			map=new int[N][N];
			coreList = new ArrayList<>();
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					int tmp = Integer.parseInt(st.nextToken());
					if(tmp==1) {
						map[i][j]=tmp;
						if(i==0||j==0||i==N-1||j==N-1) continue;
						coreList.add(new Core(i,j));
					}
				}
			}
			ans=Integer.MAX_VALUE;
			core=-1;
			solve(0,0,0);
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
	static void solve(int depth, int coreCnt, int wireCnt) {
		if(depth==coreList.size()) {
			if(core<coreCnt) {
				core =coreCnt;
				ans = wireCnt;
			}else if(core ==coreCnt) {
				ans = Math.min(ans, wireCnt);
			}
			return;
		}
		int x = coreList.get(depth).i;
		int y = coreList.get(depth).j;
		for(int dir=0;dir<4;dir++) {
			int cnt=0;
			int nx=x;
			int ny=y;
			while(true) {
				nx+=dx[dir];
				ny+=dy[dir];
				if(ny<0 || ny>=N || nx<0 || nx>=N) {
					break;
	            }
				if(map[nx][ny]==1) {
					cnt=0;
					break;
				}
				cnt++;
			}
			int wire_x=x;
			int wire_y=y;
			for(int i=0;i<cnt;i++) {
				wire_x+=dx[dir];
				wire_y+=dy[dir];
				map[wire_x][wire_y]=1;
			}
		
			if(cnt==0)solve(depth+1,coreCnt,wireCnt);
			else {
				solve(depth+1,coreCnt+1,wireCnt+cnt);
				
				wire_x=x;
				wire_y=y;
				for(int i=0;i<cnt;i++) {
					wire_x+=dx[dir];
					wire_y+=dy[dir];
					map[wire_x][wire_y]=0;
				}
			}
		}
	}
}
