import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map, move= {{1,0},{-1,0},{0,1},{0,-1}};
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		Queue<int[]> q = new LinkedList<int[]>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					q.add(new int[] {i,j});
				}
			}
		}
		int[] tmp=null;
		while(!q.isEmpty()) {
			
			tmp = q.poll();
			q.addAll(spread(tmp[0],tmp[1])); // 변경되는 위치를 다시 추가
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) { // 안익은 토마토가 남아있으면 -1출력
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(map[tmp[0]][tmp[1]]-1); // 시작이 1이므로 -1
	}
	static Queue spread(int i,int j) {
		Queue<int[]> q = new LinkedList<int[]>();
		if(map[i][j]>0) {
			for(int k=0;k<4;k++) {
				int x = i+move[k][0];
				int y = j+move[k][1];
				if(x>=0&&x<N&&y>=0&&y<M) {
					if(map[x][y]==0) {
						map[x][y]=map[i][j]+1; // 이전 위치 +1
						q.add(new int[] {x,y}); //변경되는 위치를 큐에 추가
					}
				}
			}
		}
		return q; //큐 반환
	}
}
