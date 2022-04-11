import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[][] map;
	static boolean[][] visited;
	static int[][] move = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int k = 0; k < 2; k++) {
			visited = new boolean[N][N];
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j] == false) {
						cnt++;
						dfs(i, j);
					}
					if (map[i][j] == 'G')
						map[i][j] = 'R';
				}
			}
			System.out.print(cnt+" ");
		}
//		int cnt2 = 0;
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				if (visited[i][j] == false) {
//					cnt2++;
//					dfs(i, j);
//				}
//			}
//		}
//
//		System.out.print(cnt + " " + cnt2);
	}

	static void dfs(int x, int y) {
		visited[x][y] = true;
		char c = map[x][y];
		for (int i = 0; i < 4; i++) {
			int nx = x + move[i][0];
			int ny = y + move[i][1];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
				if (map[nx][ny] == c)
					dfs(nx, ny);
			}
		}

	}
}
