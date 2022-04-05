import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] num= new int[9];
	static int[] ans= new int[7];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<9;i++) {
			num[i] = sc.nextInt();
		}
		combination(0,0);
		sc.close();
	}
	public static boolean combination(int cnt, int start) {
		if(cnt==7) {
			int sum=0;
			for(int i=0;i<ans.length;i++) {
				sum+=ans[i];
			}
			if(sum==100) {
				Arrays.sort(ans);
				for(int i=0;i<ans.length;i++) {
					System.out.println(ans[i]);
				}
				return true;
			}
			return false;
		}
		for(int i=start;i<num.length;i++) {
			ans[cnt] = num[i];
			if(combination(cnt+1,i+1)) return true;
		}
		return false;
	}
}

