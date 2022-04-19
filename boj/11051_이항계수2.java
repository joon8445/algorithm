import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int mod=10007;
	static int N,K;
	static int[][] paskal;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		paskal = new int[N+1][K+1];
		dp();
		System.out.println(paskal[N][K]);
	}
	static void dp() {
		for(int i=1;i<=N;i++) {
			paskal[i][0]=1;
			for(int j=1;j<=K;j++) {
				if(i==j) {
					paskal[i][j]=1;
					continue;
				}
				paskal[i][j]=(paskal[i-1][j-1]%mod+paskal[i-1][j]%mod)%mod;
			}
		}
	}
}
