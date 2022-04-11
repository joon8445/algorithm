import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main { // 부분집합인줄 알앗는데 조합문제였음
	static class Chicken{
		int i,j;
		Chicken(int i,int j){
			this.i = i;
			this.j = j;
		}
	}
	static int N,M,listSize,ans = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[] isSelected;
	static List<Chicken> cList = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					cList.add(new Chicken(i, j));
					map[i][j]=0;
				}
			}
		}
		listSize = cList.size();
		subset(0,new boolean[listSize]);
		System.out.println(ans);
	}
	static void subset(int cnt,boolean[] isSelected) {
		if(cnt==listSize) {
			int mCnt=0;
			for(int i=0;i<listSize;i++) {
				if(isSelected[i]) mCnt++;
			}
			if(mCnt>0&&mCnt<=M) {
				ans = Math.min(ans, newMap(isSelected));
				return;
			}
			return;
		}
		isSelected[cnt] = true;
		subset(cnt+1,isSelected);
		isSelected[cnt]= false;
		subset(cnt+1,isSelected);
	}
	static int newMap(boolean[] isSelected) {
		int sum =0;
		int[][] copyMap = new int[N][N]; 
		for(int i=0;i<N;i++) {
			copyMap[i]= map[i].clone();
		}
		for(int i=0;i<listSize;i++) {
			if(isSelected[i]) {
				Chicken c = cList.get(i);
				copyMap[c.i][c.j]=2;
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(copyMap[i][j]==1) {
					sum+=distance(i,j,copyMap);
				}
			}
		}
		return sum;
	}
	static int distance(int a,int b,int[][] cM) {
		int min = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(cM[i][j]==2) {
					min = Math.min(min, Math.abs(i-a)+Math.abs(j-b));
				}
			}
		}
		return min;
	}
}
