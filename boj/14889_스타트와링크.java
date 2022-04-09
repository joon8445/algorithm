import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] S;
	static int[] foodA, foodB;
	static int N, half, ans;
	static boolean[] isSelected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine()); // 재료의 갯수 N
		half = N / 2; // 하나의 요리에 들어갈 재료갯수
		foodA = new int[half]; // 요리에 선택된 재료들
		foodB = new int[half];
		isSelected = new boolean[N];
		S = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = Integer.MAX_VALUE; // 최솟값을 구하는 문제이기 때문에 int형 최댓값으로 초기화
		combination(0, 0); // 순서가 상관없기 때문에 조합
		sb.append(ans).append("\n");
		System.out.println(sb.toString());
	}

	static void combination(int cnt, int start) {
		if (cnt == half) { // 하나의 요리에 들어가는 재료수 만큼 뽑는다.
			for (int i = 0, index = 0; i < N; i++) {
				if (!isSelected[i]) {// foodA에 선택되지 않은재료를 foodB에 선택
					foodB[index] = i;
					index++;
				}
			}
			ans = Math.min(ans, Math.abs(taste(foodA) - taste(foodB)));
			return;
		}

		for (int i = start; i < N; i++) {
			foodA[cnt] = i;
			isSelected[i] = true;
			combination(cnt + 1, i + 1); // 다음자리는 현재 뽑은 i의 다음수부터 시작하도록 전달
			isSelected[i] = false;
		}
	}

	static int taste(int[] arr) {
		int score = 0;
		int size = arr.length;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				score += S[arr[i]][arr[j]];
			}
		}
		return score;
	}

}
