import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static class Node{
		int depth=0;
		List<Integer>next = new ArrayList<>();
		public void setNext(int next) {
			this.next.add(next);
		}
	}
	static Node[] nodes = new Node[101];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=10;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sb.append("#").append(t).append(" ");
			int length = Integer.parseInt(st.nextToken())/2;
			int start = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<=100;i++) {
				nodes[i]= new Node();
			}
			for(int i=0;i<length;i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				nodes[from].setNext(to);
			}
			call(start, 0);
			int depth =0;
			int ans=0;
			for(int i=100;i>0;i--) {
				if(depth<nodes[i].depth) {
					ans = i;
					depth = nodes[i].depth;
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
	static void call(int to,int depth) {
		if(nodes[to].depth<depth+1&&nodes[to].depth!=0) return;
		nodes[to].depth=depth+1;
		if(nodes[to].next.isEmpty()) return;
		for(int i=0;i<nodes[to].next.size();i++) {
			call(nodes[to].next.get(i),depth+1);
		}
	}
}
