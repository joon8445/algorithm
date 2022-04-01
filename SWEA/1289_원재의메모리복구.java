import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<t;i++) {
			int cnt=0;
			char[] ch = in.readLine().toCharArray();
			for(int j=ch.length-1;j>0;j--) {
				if(ch[j]==ch[j-1]) continue;
				else cnt++;
			}
			if(ch[0]=='1') cnt++;
//			System.out.printf("#%d %d\n",i+1,cnt);
			sb.append("#").append(i+1).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}
}
