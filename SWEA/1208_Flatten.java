import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 0; t < 10; t++) {
			int cnt = sc.nextInt();
			int[] height = new int[100];
			for (int i = 0; i < 100; i++) {
				height[i] = sc.nextInt();
			}
			Arrays.sort(height);
			
			while(cnt>0) {
				cnt--;
				if(height[99]-height[0]<=1) break;
				height[99]--;
				height[0]++;
				Arrays.sort(height);
			}
			
			System.out.printf("#%d %d\n", t + 1, height[99]-height[0]);
		}
		sc.close();
	}
}
