import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static char[][] map;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) map[i][j]=(char) br.read();
			br.readLine();
					
		}
		archive(N,0,0);
		System.out.println(sb.toString());
	}
	static void archive(int size, int I, int J) {
		String[] str = new String[size];
		for(int i=I;i<I+size;i++) {
			char[] clone = new char[size];
			for(int j=J;j<J+size;j++) {
				clone[j-J]=map[i][j];
			}
			Arrays.sort(clone);
			str[i-I]=String.valueOf(clone); 
		}
		Arrays.sort(str);
		if(str[0].charAt(0)==str[size-1].charAt(size-1)) {
			sb.append(str[0].charAt(0));
			return;
		}
		int half = size/2;
		sb.append("(");
		archive(half,I,J);//1
		archive(half,I,J+half);//2
		archive(half,I+half,J);//3
		archive(half,I+half,J+half);//4
		sb.append(")");
	}
}
