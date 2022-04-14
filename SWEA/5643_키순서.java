import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N,tallStud,shortStud;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			map = new int[N+1][N+1];
			for(int i=0;i<M;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				map[a][b]=1;
			}
			int ans =0;
			for(int k=1;k<=N;k++) {
				tallStud=0;
				tallBfs(k);
				shortStud=0;
				shortBfs(k);
				if(tallStud+shortStud==N-1)ans++;
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void tallBfs(int start) {//gt
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visit = new boolean[N+1];
		q.add(start);
		visit[start]=true;
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int next=1;next<=N;next++) {
				if(map[now][next]==1 && !visit[next]) {
					q.add(next);
					visit[next] =true;
					tallStud++;
				}
			}
		}
	}
	static void shortBfs(int start) {//lt
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visit = new boolean[N+1];
		q.add(start);
		visit[start]=true;
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int next=1;next<=N;next++) {
				if(map[next][now]==1 && !visit[next]) {
					q.add(next);
					visit[next] =true;
					shortStud++;
				}
			}
		}
	}

}
