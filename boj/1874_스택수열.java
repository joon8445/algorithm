import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		Deque<Integer> q = new ArrayDeque<>();
		Deque<Integer> stack = new ArrayDeque<>();
		
		int n = Integer.parseInt(br.readLine());
		for(int i=1;i<=n;i++) {
			q.offer(i);
		}
		for(int i=0;i<n;i++) {
			if(stack.isEmpty()) {
				stack.offer(q.poll());
				sb.append("+\n");
			}
			int num = Integer.parseInt(br.readLine());
			int now = stack.pollLast();
			if(now==num) {
				sb.append("-\n");
			}else if(now<num) {
				stack.offer(now);
				while(!q.isEmpty()) {
					stack.offer(q.peek());
					sb.append("+\n");
					if(q.poll()==num) {
						stack.pollLast();
						sb.append("-\n");
						break;
					}
				}
			}else {
				sb = new StringBuilder();
				sb.append("NO");
				break;
			}
		}
		System.out.println(sb.toString());
	}
}
