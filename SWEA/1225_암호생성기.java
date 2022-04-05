import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String tc;
		while(!(tc = br.readLine()).equals("")&&tc!=null) {
			sb.append("#").append(tc);
			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue<Integer> code = new ArrayDeque<Integer>();
			for(int i=0;i<8;i++) {
				code.offer(Integer.parseInt(st.nextToken()));
			}
			boolean flag = true;
			while(flag) {
				for(int i=1;i<=5;i++) {
					int tmp = code.poll()-i;
					if(tmp<=0){
						code.offer(0);
						flag=false;
						break;
					}
					code.offer(tmp);
				}
			}
			for(int i=0;i<8;i++) sb.append(" ").append(code.poll());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
