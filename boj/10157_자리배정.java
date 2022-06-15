import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken()); 
		int R = Integer.parseInt(st.nextToken()); 
		int K = Integer.parseInt(br.readLine()); 
		if(K>C*R) {
			System.out.println(0);
			return;
		}
		boolean[][] map = new boolean[R+2][C+2];
	
		for(int i=0;i<=R;i++) {
			map[i][0] = true;
			map[i][C+1] =true;
		}
		for(int i=0;i<=C;i++) {
			map[0][i] = true;
			map[R+1][i] =true;
		}
		int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
		int x=0,y=1,m=0;
		for(int i=1;i<=C*R;i++) {
			x+=move[m][0];
			y+=move[m][1];
			map[x][y] = true;
			if(map[x+move[m][0]][y+move[m][1]]) m = (m+1)%4;
			if(i==K) {
				System.out.printf("%d %d",y,x);
			}
		}
	}
}
