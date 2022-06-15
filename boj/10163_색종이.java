import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map = new int[1001][1001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for (int t = 1; t <= N; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			for (int i = x; i < x + w; i++) {
				for (int j = y; j < y + h; j++) {
					map[i][j] = t;
				}
			}
		}
		int[] ans = new int[N + 1];
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				ans[map[i][j]]++;
			}
		}
		for (int i = 1; i <= N; i++) {
			sb.append(ans[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
