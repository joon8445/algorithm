import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			sb.append("#").append(t).append(" ");
			int ans=0;
			int N= Integer.parseInt(br.readLine());
			int[] num = new int[N+1];
			int[] dp = new int[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1;i<=N;i++) {
				num[i]=Integer.parseInt(st.nextToken());
			}
			for(int i=1;i<=N;i++) {
				for(int j=0;j<i;j++) {
					if(num[i]>=num[j]) {
						dp[i]=Math.max(dp[j]+1, dp[i]);
					}
				}
				ans = Math.max(ans, dp[i]);
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
}
