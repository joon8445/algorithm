import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans[] = new int[n+1];
		for(int i=2;i<=n;i++) {
			ans[i]=ans[i-1]+1;
			if(i%2==0)ans[i]=Math.min(ans[i],ans[i/2]+1);
	        if(i%3==0)ans[i]=Math.min(ans[i],ans[i/3]+1);
		}
		System.out.println(ans[n]);
	}
}
