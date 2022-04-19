import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int mod=1000000007;
	static int N,K;
	static long nFac=1,kFac=1,n_kFac=1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp();
		long parent = n_kFac*kFac%mod;
		long ans = nFac*(power(parent,mod-2))%mod;
		System.out.println(ans);
	}
	static long power(long a,long b) {
		if(b==0)return 1;
		long half = power(a,b/2);
		if(b%2==1) {
			return (half*half%mod)*a%mod;
		}
		return half*half%mod;
	}
	static void dp() {
		long f=1;
		for(int i=1;i<=N;i++) {
			f=(f*i)%mod;
			if(i==N) nFac=f;
			if(i==N-K) n_kFac=f;
			if(i==K) kFac=f;
		}
	}
}
