import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=T;t++) {
			sb.append("#").append(t).append(" ");
			int N = Integer.parseInt(br.readLine());
			boolean flag=false;
			StringTokenizer st =new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d=Math.abs(x)+Math.abs(y);
			int mod= d%2;
			int max =d;
			for(int i=1;i<N;i++) {
				st =new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				d=Math.abs(x)+Math.abs(y);
				max = Math.max(d, max);
				if(mod!=d%2) {
					flag=true;
				}
			}
			if(flag) {
				sb.append("-1\n");
				continue;
			}
			int ans=0;
			while(max>0){
				max-=++ans;
			}
			if(max%2!=0) {
				if(ans%2==1) {
					ans+=2;
				}else {
					ans++;
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
}
