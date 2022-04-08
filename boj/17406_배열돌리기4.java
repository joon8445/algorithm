import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, min = Integer.MAX_VALUE;
	static int[] R, C, S, P;
	static int[][] a, clone;
	static boolean isSelected[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		a = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		P = new int[K]; // 순열을 위한 배열
		R = new int[K]; // R값
		S = new int[K]; // S값
		C = new int[K]; // C값
		isSelected = new boolean[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			R[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			S[i] = Integer.parseInt(st.nextToken());
		}
		permutation(0);
		System.out.println(min);

	}

	static void permutation(int cnt) {
		if (cnt == K) {//순열 생성
			clone = new int[N][M]; //복사배열
			for (int i = 0; i < N; i++) {
				clone[i] = a[i].clone();
			}
			for (int i = 0; i < K; i++) {
				rotation(R[P[i]], C[P[i]], S[P[i]]); // 각 순열에 해당하는 rotation
			}
			min = Math.min(min, arrayValue());
			return;
		}
		for (int i = 0; i < K; i++) {
			if (isSelected[i]) continue;
			P[cnt] = i;
			isSelected[i] = true;
			permutation(cnt + 1);
			isSelected[i] = false;

		}
	}

	static int arrayValue() { // 행의 모든 수를 더햇을 때 최소값
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++) {
				sum += clone[i][j];
			}
			min = Math.min(min, sum);
		}
		return min;
	}

	static void rotation(int r, int c, int s) { // 시계방향 회전
		if (s == 0) {
			return;
		}
		int[] start = { r - s - 1, c - s - 1 };
		int[] end = { r + s - 1, c + s - 1 };
		int tmp = clone[start[0]][start[1]];
		for (int i = start[0]; i < end[0]; i++) clone[i][start[1]] = clone[i + 1][start[1]]; // 좌 ^
		for (int i = start[1]; i < end[1]; i++) clone[end[0]][i] = clone[end[0]][i + 1]; // 하 <
		for (int i = end[0]; i > start[0]; i--) clone[i][end[1]] = clone[i - 1][end[1]]; // 우 v
		for (int i = end[1]; i > start[1]; i--) clone[start[0]][i] = clone[start[0]][i - 1]; // 상 >
		clone[start[0]][start[1] + 1] = tmp;
		rotation(r, c, s - 1);
	}
}
