import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int n = Integer.parseInt(br.readLine());
			Queue<String> card1 = new ArrayDeque<String>();
			Queue<String> card2 = new ArrayDeque<String>();
			st= new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				if(i<((n+1)/2)) {
					card1.offer(st.nextToken());
				}else {
					card2.offer(st.nextToken());
				}
			}
			sb.append("#").append(t);
			for(int i=0;i<((n+1)/2);i++) {
				sb.append(" ").append(card1.poll());
				if(card2.peek()!=null) sb.append(" ").append(card2.poll());
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
