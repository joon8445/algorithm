import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, result=Integer.MAX_VALUE;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0,new boolean[N],0);
		System.out.println(result);
	}
	static void dfs(int depth, int now,boolean[] visited,int sum) {
		if(depth == N-1) {
			if(map[now][0]!=0) {
				sum+=map[now][0];
				result = Math.min(result, sum);
			}
			return;
		}
		visited[now] = true;
		for(int i=0;i<N;i++) {
			if(!visited[i]&&sum+map[now][i]<result&&map[now][i]!=0) {
				dfs(depth+1,i,visited.clone(),sum+map[now][i]);
			}
		}
	}
	
}
