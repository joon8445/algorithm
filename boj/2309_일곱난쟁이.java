import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] height = new int[9];
		int[] ans = new int[7];
		int sum=0,fake1 = 0,fake2=0;
		for(int i=0;i<9;i++) {
			height[i] = Integer.parseInt(br.readLine());
			sum+= height[i];
		}
		for(int i=0;i<9;i++) {
			for(int j=i+1;j<9;j++) {
				if(sum-height[i]-height[j]==100) {
					fake1=i;
					fake2=j;
				}
			}
		}
		
		for(int i=0,j=0;i<9;i++) {
			if(i==fake1||i==fake2) {
				continue;
			}
			ans[j++]=height[i];
		}
		Arrays.sort(ans);
		for(int i=0;i<7;i++) {
			sb.append(ans[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
