import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(solve(n));
		
	}
	static int solve(int n) {
		if(n==4||n==7) return -1; // 4,7일 경우 불가능
		int five =0,three=0; // 5가방, 3가방
		for(;n>12;five++) { //12(3의배수 최댓값) 보다 클경우 더 큰 가방인 5에 넣음 이후에는 n이(8~12)
			n-=5;
		}
		for(;n%3!=0;five++) { // 3으로 나눠지지 않으면 5에 넣음(5=0,6,8=3,9,10은 0,11은6,12)
			n-=5;
		}
		three +=n/3;
		return five+three;
	}
}
