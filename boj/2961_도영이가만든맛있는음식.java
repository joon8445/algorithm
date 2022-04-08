import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] bitter, sour;
	static int diff=Integer.MAX_VALUE,N;
	static boolean[] isSelected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N= Integer.parseInt(br.readLine());
		isSelected = new boolean[N];
		bitter = new int[N];
		sour = new int[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		subset(0); // 모든 경우의 수를 확인
		System.out.println(diff);
	}
	static void subset(int cnt) {
		if(cnt==N) {
			int sum=0,mul=1;
			for(int i=0;i<N;i++) {
				if(isSelected[i]) {
					sum+=bitter[i];
					mul*=sour[i];
				}
			}
			if(sum!=0) diff = Math.min(Math.abs(mul-sum),diff); // sum이 0일경우 아무것도 선택되지 않았을 때 이므로 제외
			return;
		}
		isSelected[cnt] = true;
		subset(cnt+1);
		isSelected[cnt] = false;
		subset(cnt+1);
	}
}
