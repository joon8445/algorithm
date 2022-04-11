import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] set,cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=T;t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			makeSet(N);
			cnt = new int[N+1];
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a,b);
			}
			for(int i=1;i<=N;i++) {
				find(i);
			}
			for(int i=1;i<=N;i++) {
				cnt[set[i]]=1;
			}
			int sum=0;
			for(int i=1;i<=N;i++) {
				sum+=cnt[i];
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}
	static void makeSet(int n) {
		set = new int[n+1];
		for(int i=0;i<=n;i++) {
			set[i]=i;
		}
	}
	static int find(int a) {
		if(a==set[a]) return a;
		return set[a] = find(set[a]);
	}
	static void union(int a,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot==bRoot) return;
		set[bRoot] = aRoot;
		return;
	}
}
