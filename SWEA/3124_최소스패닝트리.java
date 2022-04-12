import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static class Edge implements Comparable<Edge>{
		int from,to,weight;
		
		public Edge(int from,int to,int weight) {
			super();
			this.from =from;
			this.to = to;
			this.weight = weight;
		}
		public int compareTo(Edge o) {
			return this.weight-o.weight;
		}
	}
	static int[] parents;
	static Edge[] edgeList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		for(int t=1;t<=T;t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			edgeList = new Edge[E];
			for(int i=0;i<E;i++) {
				st= new StringTokenizer(br.readLine());
				int A=Integer.parseInt(st.nextToken());
				int B=Integer.parseInt(st.nextToken());
				int C=Integer.parseInt(st.nextToken());
				edgeList[i]=new Edge(A,B,C);
			}
			Arrays.sort(edgeList);
			makeSet(V+1);
			long result = 0;
			int cnt =0;
			for(Edge edge:edgeList) {
				if(union(edge.from,edge.to)) {
					result +=edge.weight;
					if(++cnt == V-1) break;
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());
	}
	static void makeSet(int N) {
		parents = new int[N];
		for(int i=0;i<N;i++) {
			parents[i]=i;
		}
	}
	static int findSet(int a) {
		if(a==parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot==bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
}
