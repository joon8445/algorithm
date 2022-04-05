package workshop.ws0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=TC;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int ans =-1;
			int[] a = new int[N];
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				a[i]= Integer.parseInt(st2.nextToken());
			}
			for(int i=0;i<N-1;i++) {
				for(int j=i+1;j<N;j++) {
					if(a[i]+a[j]<M) {
						ans = Math.max(a[i]+a[j], ans);
					}else if(a[i]+a[j]==M) {
						ans = M;
						i=N;
						break;
					}
				}
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}
