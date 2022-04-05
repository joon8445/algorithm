import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=10;t++) {
			int N = Integer.parseInt(br.readLine());
			List<String> pwd = new ArrayList<String>();
			int x=0,y=0;
			String[] str=null;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				pwd.add(st.nextToken());
			}
			int cn = Integer.parseInt(br.readLine());
			String[] line = br.readLine().split("I");
			for(int i=0;i<cn;i++) {
				List<String> command = new ArrayList<String>();
				str = line[i+1].split(" ");
				x=Integer.parseInt(str[1]);
				y=Integer.parseInt(str[2]);
				for(int j=0;j<y;j++) {
					command.add(str[j+3]);
				}
				pwd.addAll(x,command);
			}
			sb.append("#").append(t);
			for(int k=0;k<10;k++) {
				sb.append(" ").append(pwd.get(k));
			}
			sb.append("\n");
			
		}
		System.out.println(sb.toString());
	}
}
