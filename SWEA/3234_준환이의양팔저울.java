package workshop.ws0218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N, ans;
	static int[] w, choice, fac=new int[10];
	static boolean[] isSelected;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		fac[1]=1;
		for(int i=2;i<10;i++) {
			fac[i] =fac[i-1]*i;
		}
		for (int t = 1; t <= T; t++) {
			ans = 0;
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = new int[N];
			choice = new int[N];
			isSelected = new boolean[N];
			int sum = 0;
			for (int i = 0; i < N; i++) {
				w[i] = Integer.parseInt(st.nextToken());
				sum+=w[i];
			}
			permutation(0,0,0,sum);
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void permutation(int cnt,int sumL,int sumR,int remain) {
		if (cnt == N) {
			ans++;
			return;
		}
		if(sumL>=sumR+remain) {
			ans+= fac[N-cnt]*(1<<(N-cnt)) ;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (isSelected[i])
				continue;
			isSelected[i] = true;
			permutation(cnt + 1,sumL+w[i],sumR,remain-w[i]);
			if(sumR+w[i]<=sumL) {
				permutation(cnt+1,sumL,sumR+w[i],remain-w[i]);
			}
			isSelected[i] = false;
		}
	}
}
