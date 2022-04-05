import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			br.readLine();
			String[][] map = new String[100][100];
			for (int i = 0; i < 100; i++) {
				map[i] = br.readLine().split(" ");
			}
			int start=0, current=0;
			for (int i = 0; i < 100; i++) {
				if (map[99][i].equals("2")) {
					current = i;
					break;
				}
			}
			for (int i = 99; i >= 0; i--) {
				int next = 0;
				boolean flag = true;
				while (flag) {
					if (current == 0 ) {
						if (map[i][current + 1].equals("1")&& next !=-1) {
							current++;
							next=1;
						}else {
							next=0;
							flag=false;
						}
					}else if(current == 99 ) {
						if(map[i][current - 1].equals("1")&& next != 1) {
							current--;
							next=-1;
						}else {
							next=0;
							flag=false;
						}
					}else if(map[i][current -1].equals("1") && next!=1) {
						current--;
						next=-1;						
					}else if(map[i][current +1].equals("1") && next!=-1) {
						current++;
						next = 1;
					}else {
						next=0;
						flag=false;
					}					
				}
			}
			start = current;
			sb.append("#").append(t).append(" ").append(start).append("\n");

		}
		System.out.println(sb.toString());
	}
}
