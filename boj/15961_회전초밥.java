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
		int[] belt = new int[N];
		int[] eat=new int[d+1];
		Queue<Integer> q = new ArrayDeque<Integer>();
		int ans =0;
		int cnt=0;
		for(int i=0;i<N;i++) {
			belt[i]=Integer.parseInt(br.readLine());
		}
		for(int i=0;i<k;i++) {
			if(eat[belt[i]]==0)cnt++;
			eat[belt[i]]++;
			q.offer(belt[i]);
		}
		for(int i=0;i<N;i++) {
			if(eat[c]==0)cnt++;
			eat[c]++;
			ans=Math.max(ans, cnt);
			eat[c]--;
			if(eat[c]==0)cnt--;
			eat[q.peek()]--;
			if(eat[q.poll()]==0)cnt--;
			if(eat[belt[(i+k)%N]]==0)cnt++;
			eat[belt[(i+k)%N]]++;
			q.offer(belt[(i+k)%N]);
		}
		System.out.println(ans);
	}
}
