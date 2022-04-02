import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Tower {
	int idx;
	int height;

	Tower(int idx, int height) {
		this.idx = idx;
		this.height = height;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tower;
		Stack<Tower> stack = new Stack<Tower>();
		stack.push(new Tower(0, 0));
		for (int i = 1; i <= n; i++) {
			tower = Integer.parseInt(st.nextToken());
			while (true) {
				if (stack.isEmpty()) {
					ans.append("0 ");
					stack.push(new Tower(i, tower));
					break;
				}
				Tower tmp = stack.peek();
				if (tmp.height > tower) {
					ans.append(tmp.idx).append(" ");
					stack.push(new Tower(i, tower));
					break;
				} else {
					stack.pop();
				}
			}

		}
			System.out.print(ans.toString());
	}
}
