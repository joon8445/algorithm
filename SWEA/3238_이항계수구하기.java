import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int mod;
	static long N,K;
	static long nFac=1,kFac=1,n_kFac=1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st= new StringTokenizer(br.readLine());
			N = Long.parseLong(st.nextToken());
			K = Long.parseLong(st.nextToken());
			mod = Integer.parseInt(st.nextToken());
			dp();
			long parent = n_kFac*kFac%mod;
			long ans = nFac*(power(parent,mod-2))%mod;
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
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
		for(int i=1;i<=mod;i++) {
			f=(f*i)%mod;
			if(i==N) nFac=f;
			if(i==N-K) n_kFac=f;
			if(i==K) kFac=f;
		}
	}
}
