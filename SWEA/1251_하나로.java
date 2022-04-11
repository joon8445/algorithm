import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			sb.append("#").append(t).append(" ");
			int N = Integer.parseInt(br.readLine());
			double[][] map = new double[N][N];
			int[] x = new int[N], y = new int[N];
			double minEdge[] = new double[N];
			boolean[] visited = new boolean[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) x[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) y[i] = Integer.parseInt(st.nextToken());
			double E = Double.parseDouble(br.readLine());
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					double tmp = (E*(x[i]-x[j])*(x[i]-x[j])+E*(y[i]-y[j])*(y[i]-y[j]));
					map[i][j] = tmp;
					map[j][i] = map[i][j];
				}
				minEdge[i] = Double.MAX_VALUE;
			}
			double result = 0;
			minEdge[0] = 0;
			
			for(int c=0;c<N;c++) {
				double min = Double.MAX_VALUE;
				int minVertex = 0;
				for(int i=0;i<N;i++) {
					if(!visited[i]&&min>minEdge[i]) {
						min = minEdge[i];
						minVertex = i;
					}
				}
				visited[minVertex] = true;
				result += min;
				
				for(int i=0;i<N;i++) {
					if(!visited[i]&&map[minVertex][i]!=0&&minEdge[i]>map[minVertex][i]) {
						minEdge[i] = map[minVertex][i];
					}
				}
			}
			sb.append(Math.round(result)).append("\n");
		}
		System.out.println(sb.toString());
	}
}
