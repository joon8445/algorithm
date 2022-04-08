import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			int ans = 1;
			int N = Integer.parseInt(br.readLine());
			for(int i=0;i<N;i++) {
				String[] data = br.readLine().split(" ");
				if(data.length==2) {
					if(data[1].equals("+")||data[1].equals("-")||data[1].equals("/")||data[1].equals("*")) { // 리프 노드 일경우 숫자가 아니라면 계산 불가능
						ans =0;
					}
				}else {
					if(!data[1].equals("-")&&!data[1].equals("+")&&!data[1].equals("*")&&!data[1].equals("/")) {// 줄기,루트 노드일경우 숫자일 경우 계산 불가능
						ans =0;
					}
				}
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
	
}
