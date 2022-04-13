import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int r=0,g=0,b=0;
		int[] cost= new int[3];
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			r+=Math.min(cost[1], cost[2]);
			g+=Math.min(cost[0], cost[2]);
			b+=Math.min(cost[1], cost[0]);
			cost[0]=r;
			cost[1]=g;
			cost[2]=b;
		}
		System.out.println(Math.min(cost[0], Math.min(cost[1], cost[2])));
		
	}
}
