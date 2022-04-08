import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static boolean[][] isChecked;
	static int[][] cnt, map;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N]; // 입력배열
			isChecked = new boolean[N][N];
			cnt = new int[N][N]; // 이동가능한 개수배열
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					check(i, j);
			}
			int max = 0;
			int ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (max < cnt[i][j]) { // 카운팅한 결과가 클때
						max = cnt[i][j];
						ans = map[i][j]; // 해당자리의 값
					}
					if (max == cnt[i][j]) { // 숫자가 같으면 작은것
						ans = Math.min(ans, map[i][j]);
					}
				}
			}
			sb.append("#").append(t).append(" ").append(ans).append(" ").append(max + 1).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void check(int row, int col) {
		if (isChecked[row][col]) return; // 해당자리 체크 했을 경우 리턴
		isChecked[row][col] = true; 
		
		if (row > 0) {
			if (map[row][col] + 1 == map[row - 1][col]) { // 상 검사
				check(row - 1, col);
				cnt[row][col] = cnt[row - 1][col] + 1;
				return;
			}
		}
		if (row < N - 1) {
			if (map[row][col] + 1 == map[row + 1][col]) { // 하 검사
				check(row + 1, col);
				cnt[row][col] = cnt[row + 1][col] + 1;
				return;
			}
		}
		if (col > 0) {
			if (map[row][col] + 1 == map[row][col - 1]) { // 좌 검사
				check(row, col - 1);
				cnt[row][col] = cnt[row][col - 1] + 1;
				return;
			}
		}
		if (col < N - 1) {
			if (map[row][col] + 1 == map[row][col + 1]) { // 우 검사
				check(row, col + 1);
				cnt[row][col] = cnt[row][col + 1] + 1;
				return;
			}
		}

		return;
	}
}
