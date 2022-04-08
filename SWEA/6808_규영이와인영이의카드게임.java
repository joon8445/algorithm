import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static boolean[] isSelected, num;
	static int[] gyu, in,tmp;
	static int win,lose;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			isSelected = new boolean[9];
			num = new boolean[19];
			gyu = new int[9];
			tmp = new int[9];
			in = new int[9];
			win=0;
			lose=0;
			for(int i=0;i<9;i++) {
				gyu[i] = Integer.parseInt(st.nextToken());  
				num[gyu[i]]=true;
			}
			for(int cnt=0,i=1;i<19;i++) {
				if(num[i]) continue; // 규영이가 갖지않은 카드를 tmp에 넣어준다.
				tmp[cnt++]=i;
			}
			permutation(0);
			sb.append("#").append(t).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		System.out.println(sb.toString());
	}
	static void permutation(int cnt) {
		if(cnt==9) {
			int gyuScore=0, inScore=0;
			for(int i=0;i<9;i++) {
				if(gyu[i]<in[i]) {
					inScore +=gyu[i]+in[i];//인영점수
				}
				else {
					gyuScore +=gyu[i]+in[i];//규영점수
				}
			}
			if(gyuScore<inScore) {
				lose++;
			}else if(inScore<gyuScore) {
				win++;
			}
		}
		for(int i=0;i<9;i++) {
			if(isSelected[i]) continue;
			
			in[cnt] = tmp[i]; //tmp에 있는수들을 순열
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}
}
