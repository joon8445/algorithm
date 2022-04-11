import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] set;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=T;t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n= Integer.parseInt(st.nextToken());
			int m= Integer.parseInt(st.nextToken());
			set = new int[n+1];
			for(int i=0;i<=n;i++) {
				set[i]=i;
			}
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int oper = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				switch (oper) {
				case 0:
					union(a,b);
					break;
				case 1:
					findSet(a);
					findSet(b);
					if(set[a]==set[b]) sb.append(1);
					else sb.append(0);
					break;
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	static int findSet(int a) {
		if(a==set[a]) return a;
		return set[a] = findSet(set[a]);
	}
	static void union(int a,int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return;
		set[bRoot] = aRoot;
		return;
	}
}
