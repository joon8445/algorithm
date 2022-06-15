import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());
		x = solve(t,w,x);
		y = solve(t,h,y);
		System.out.printf("%d %d",x,y);
	}
	static int solve(int t, int mapSize,int ant) {
		int x = (ant+t)%(mapSize*2);
		ant = mapSize - Math.abs(mapSize-x);
		return ant;
	}
}
