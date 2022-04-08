import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[100][100];
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int j=0;j<10;j++) {
				for(int k=0;k<10;k++) {
					map[x+j][y+k] = 1;
				}
			}
		}
		int sum=0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				sum+=map[i][j];
			}
		}
		System.out.println(sum);
	}
}
