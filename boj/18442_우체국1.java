import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int V,P,police[];
	static long L,ans;
	static long[] village;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		L = Long.parseLong(st.nextToken());
		village = new long[V];
		police = new int[P];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < V; i++) {
			village[i] = Long.parseLong(st.nextToken());
		}
		ans = Long.MAX_VALUE;
		solve();
		sb.append(ans).append("\n");
		for (int i = 0; i < P; i++) {
			sb.append(village[police[i]]).append(" ");
		}
		sb.append("\n");
		System.out.println(sb.toString());
	}

	static void solve() {
		int[] idx = new int[P];
		combination(0, 0, idx);
	}

	static void combination(int cnt, int start, int[] idx) {
		if (cnt == P) {
			simul(idx);
			return;
		}
		for (int i = start; i < V; i++) {
			idx[cnt] = i;
			combination(cnt + 1, i + 1, idx);
		}
	}

	static void simul(int[] idx) {
		long cnt = 0;
		for (int i = 0; i < V; i++) {
			long d = Long.MAX_VALUE;
			for (int j = 0; j < P; j++) {
				d = Math.min(d, distance(village[i], village[idx[j]]));
			}
			cnt += d;
		}
		if (ans > cnt) {
			police = idx.clone();
			ans = cnt;
		}
	}

	static long distance(long x, long y) {
		long d = Math.abs(x - y);
		return Math.min(d, L - d);
	}
}
