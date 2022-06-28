package study.IM_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static class pillar implements Comparable<pillar>{
		int index,height;
		public pillar(int i,int h) {
			super();
			this.index = i;
			this.height = h;
		}
		@Override
		public int compareTo(pillar o) {
			return this.index-o.index;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		pillar[] p = new pillar[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			p[i] = new pillar(index,height);
		}
		Arrays.sort(p);
		int frontMax = 0, frontMaxIdx=-1;
		for(int i=0;i<N;i++) {
			if(p[i].height>frontMax) {
				frontMax=p[i].height;
				frontMaxIdx=i;
			}
		}
		int backMax = 0, backMaxIdx=-1;
		for(int i=N-1;i>=0;i--) {
			if(p[i].height>backMax) {
				backMax=p[i].height;
				backMaxIdx=i;
			}
		}
		sb.append(roof(p,frontMaxIdx,backMaxIdx,backMax));
		System.out.println(sb.toString());
	}
	static int roof(pillar[] p,int fMaxIdx,int bMaxIdx, int max) {
		int width=0;
		int x=p[0].index,y=p[0].height;
		for(int i=0;i<=fMaxIdx;i++) {
			if(p[i].height>y) {
				width+=(p[i].index-x)*y;
				y=p[i].height;
				x=p[i].index;
			}
		}
		x=p[N-1].index; 
		y=p[N-1].height;
		for(int i=N-1;i>=bMaxIdx;i--) {
			if(p[i].height>y) {
				width+=(x-p[i].index)*y;
				y=p[i].height;
				x=p[i].index;
			}
		}
		width += (p[bMaxIdx].index-p[fMaxIdx].index+1)*max;
		return width;
	}
}
