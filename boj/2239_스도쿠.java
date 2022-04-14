import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[][] sudoku = new int[10][10];
	static boolean[][] row=new boolean[10][10],col=new boolean[10][10],box=new boolean[10][10];
	static boolean finish;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<9;i++) {
			String str = br.readLine();
			for(int j=0;j<9;j++) {
				int tmp = Integer.parseInt(str.substring(j,j+1));	
				sudoku[i][j] = tmp;	
				if(tmp!=0) {
					row[i][tmp]=true;
					col[j][tmp]=true;
					box[(i/3)*3+(j/3)][tmp]=true;
				}
			}
		}
		dfs(0);
		System.out.println(sb.toString());
	}
	static void dfs(int cnt) {
		if(finish) return;
		int x = cnt/9;
		int y = cnt%9;
		if(cnt == 81) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					sb.append(sudoku[i][j]);
				}
				sb.append("\n");
			}
			finish = true;
		}
		if(sudoku[x][y]==0) {
			for(int i=1;i<=9;i++) {
				if(!row[x][i]&&!col[y][i]&&!box[(x/3)*3+(y/3)][i]) {
					row[x][i]=true;
					col[y][i]=true;
					box[(x/3)*3+(y/3)][i]=true;
					sudoku[x][y]=i;
					dfs(cnt+1);
					sudoku[x][y]=0;
					row[x][i]=false;
					col[y][i]=false;
					box[(x/3)*3+(y/3)][i]=false;
				}
			}
		}
		else dfs(cnt+1);
	}
}
