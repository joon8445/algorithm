import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N,M,L,ans,t;
	static int start = 0, up=1,down=2,left=3,right=4;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(t=1;t<=T;t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			int R=Integer.parseInt(st.nextToken());
			int C=Integer.parseInt(st.nextToken());
			L=Integer.parseInt(st.nextToken());
			map = new int[N][M];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			ans=0;
			solve(R,C);
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
	static void solve(int r,int c) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] {r,c,1,start});
		boolean[][] visit = new boolean[N][M];
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int time = q.peek()[2];
			int pre = q.poll()[3];
			if(x<0||y<0||x>=N||y>=M||map[x][y]==0) continue;//범위확인
			if(time>L)continue;
			int tunnel = map[x][y];//터널존재 확인
			if(pre!=start&&tunnel!=1) {// 갈수있는 터널인지 확인
				if(pre!=up) {
					if(pre!=down) {
						if(pre==left) {//left 3,4,5
							if(!(tunnel==3||tunnel==4||tunnel==5)) continue;
						}else {//right 3,6,7
							if(!(tunnel==3||tunnel==6||tunnel==7)) continue;
						}
					}else {//down 2,4,7
						if(!(tunnel==2||tunnel==4||tunnel==7)) continue;
					}
				}else {// up 2,5,6
					if(!(tunnel==2||tunnel==5||tunnel==6)) continue;
				}
			}
			if(visit[x][y]) continue; // 방문 확인
			visit[x][y]=true;
			ans++;
			switch (tunnel) {
			case 1:
				q.add(new int[] {x-1,y,time+1,up});
				q.add(new int[] {x+1,y,time+1,down});
				q.add(new int[] {x,y-1,time+1,left});
				q.add(new int[] {x,y+1,time+1,right});
				break;
			case 2:
				q.add(new int[] {x-1,y,time+1,up});
				q.add(new int[] {x+1,y,time+1,down});
				break;
			case 3:
				q.add(new int[] {x,y-1,time+1,left});
				q.add(new int[] {x,y+1,time+1,right});
				break;
			case 4:
				q.add(new int[] {x-1,y,time+1,up});
				q.add(new int[] {x,y+1,time+1,right});
				break;
			case 5:
				q.add(new int[] {x+1,y,time+1,down});
				q.add(new int[] {x,y+1,time+1,right});
				break;
			case 6:
				q.add(new int[] {x+1,y,time+1,down});
				q.add(new int[] {x,y-1,time+1,left});
				break;
			case 7:
				q.add(new int[] {x-1,y,time+1,up});
				q.add(new int[] {x,y-1,time+1,left});
				break;
			}
		}
	}
}
