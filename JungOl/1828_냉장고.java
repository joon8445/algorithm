import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static class chem implements Comparable<chem>{
		int high,low;
		public chem(int h,int l) {
			high =h;
			low =l;
		}
		@Override
		public int compareTo(chem o) {
			if(this.high==o.high) return this.low-o.low;
			return this.high-o.high;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		chem[] c = new chem[N];
 
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int low=Integer.parseInt(st.nextToken());
			int high=Integer.parseInt(st.nextToken());
			c[i] = new chem(high,low); 
		}
		Arrays.sort(c);
		int cnt=1;
		int max=c[0].high;
		for(int i=1;i<N;i++) {
			if(c[i].low>max) {
				max=c[i].high;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
