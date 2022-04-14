import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int d=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		int[] eat=new int[d+1];
		int[] start=new int[d+1];
		Queue<Integer> q = new ArrayDeque<Integer>();
		int ans =0;
		for(int i=1;i<=N;i++) {
			int tmp=Integer.parseInt(br.readLine());
			if(i<k) start[i]=tmp;
			eat[tmp]++;
			q.offer(tmp);
			if(i>=k) {
				eat[c]++;
				int cnt = count(eat);
				ans=Math.max(ans, cnt);
				if(ans==d) {
					System.out.println(ans);
					return;
				}
				eat[c]--;
				eat[q.poll()]--;
			}
		}
		for(int i=1;i<k;i++) {
			eat[start[i]]++;
			q.offer(start[i]);
			eat[c]++;
			ans=Math.max(ans, count(eat));
			eat[c]--;
			eat[q.poll()]--;
		}
		System.out.println(ans);
	}
	static int count(int[] arr) {
		int length = arr.length;
		int cnt=0;
		for(int i=0;i<length;i++) {
			if(arr[i]!=0)cnt++;
		}
		return cnt;
	}
}
