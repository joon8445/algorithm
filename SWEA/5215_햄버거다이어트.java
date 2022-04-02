import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int bestChoice, N,L;
	static int[] taste,kcal;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());;
			L = Integer.parseInt(st.nextToken());
			taste = new int[N];
			kcal = new int[N];
			for(int i=0;i<N;i++) {
				taste[i]=Integer.parseInt(st.nextToken());
				kcal[i] =Integer.parseInt(st.nextToken());
			}
			bestChoice = 0;
			choose(0,0,0);
			
			sb.append(bestChoice).append("\n");
		}
		System.out.println(sb.toString());
	}
	static void choose(int cnt, int choice, int cal) {
		if (cal > L) return;
		if (cal <=L) bestChoice = Math.max(bestChoice, choice);
		if (cnt ==N) return;
		
		//선택
		choose(cnt+1, choice+taste[cnt],cal+kcal[cnt]);
		
		//선택X
		choose(cnt+1, choice,cal);
		
	}

}
