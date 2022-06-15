import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] student = new int[7][2];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			student[Y][S]++;
		}
		int ans=0;
		for(int i=1;i<=6;i++) {
			if(student[i][0]%K!=0) ans++;
			if(student[i][1]%K!=0) ans++;
			ans += student[i][0]/K;
			ans += student[i][1]/K;
		}
		System.out.println(ans);
	}
}
