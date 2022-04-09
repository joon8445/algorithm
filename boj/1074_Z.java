import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int cnt = 0;
		List<Integer> col = new ArrayList<Integer>();
		col.add(0);
		List<Integer> row = new ArrayList<Integer>();
		row.add(0);
		for (int i = 0; i < N; i++) {
			col.add((int) Math.pow(4, cnt));
			row.add((int) Math.pow(4, cnt) * 2);
			cnt++;
			int size = col.size() - 1;
			for (int j = 1; j < size; j++) {
				col.add(col.get(col.size() - 1) + col.get(j) - col.get(j - 1));
				row.add(row.get(row.size() - 1) + row.get(j) - row.get(j - 1));
			}
		}
		System.out.println(col.get(r) + row.get(c));
	}
}
