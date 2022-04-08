import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new ArrayDeque<Integer>();
		for(int i=1;i<=n;i++) {
			queue.offer(i);
		}
		sb.append("<");
		while(!queue.isEmpty()) {
			for(int i=1;i<k;i++) {
				queue.offer(queue.poll());
			}
			sb.append(queue.poll()).append(", ");
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb.toString());
	}
}
