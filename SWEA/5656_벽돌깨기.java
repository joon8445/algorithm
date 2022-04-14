import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	static int[][] map,mapCopy;
	static int N,W,H,ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			sb.append("#").append(t).append(" ");
			ans =0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			int brick=0;
			for(int i=0;i<H;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<W;j++) {
					int tmp=Integer.parseInt(st.nextToken());
					map[i][j]= tmp;
					if(tmp!=0) {
						brick++;
					}
				}
			}
			permutation(0, new int[N]);
			sb.append(brick-ans).append("\n");
		}
		System.out.println(sb.toString());
	}
	static void permutation(int cnt, int[] num) {
		if(cnt==N) {
			simul(num);
			return;
		}
		for(int i=0;i<W;i++) {
			num[cnt]=i;
			permutation(cnt+1, num);
		}
	}
	static void simul(int[] num) {
		mapCopy = new int[H][W];
		int cnt=0;
		for(int i=0;i<H;i++) {
			mapCopy[i]=map[i].clone();
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<H;j++) {
				if(mapCopy[j][num[i]]!=0) {
					cnt += marble(j,num[i]);
					break;
				}
			}
			after();
		}
		ans=Math.max(ans, cnt);
	}
	static int marble(int x,int y) {
		int cnt=0;
		int num = mapCopy[x][y];
		mapCopy[x][y]=0;
		if(num!=0) cnt++;
		for(int i=1;i<num;i++) {
			if(x+i<H) {
				cnt+=marble(x+i,y);
			}
			if(y+i<W) {
				cnt+=marble(x,y+i);
			}
			if(x-i>=0) {
				cnt+=marble(x-i,y);
			}
			if(y-i>=0) {
				cnt+=marble(x,y-i);
			}
		}
		return cnt;
	}
	static void after() {
		for(int i=0;i<W;i++) {
			Stack<Integer> stack =new Stack<>();
			for(int j=0;j<H;j++) {
				if(mapCopy[j][i]!=0) {
					stack.push(mapCopy[j][i]);
				}
			}
			for(int j=H-1;j>=0;j--) {
				if(stack.isEmpty())mapCopy[j][i]=0;
				else mapCopy[j][i]=stack.pop();
			}
		}
		return;
	}
}
