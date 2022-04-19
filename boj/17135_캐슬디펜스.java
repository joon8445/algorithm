import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static Stack<Integer> clone[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		Stack<Integer> map[] = new Stack[M]; 
		clone = new Stack[M];
		for (int i = 0; i < M; i++) {
			clone[i]= new Stack<Integer>();
			map[i] = new Stack<Integer>();
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == 1)
					map[j].push(i);
			}
		}
		
		int ans = 0;
		for (int i = 0; i < M; i++) {
			for (int j = i + 1; j < M; j++) {
				for (int k = j + 1; k < M; k++) {
					for(int l=0;l<M;l++) clone[l]=(Stack<Integer>) map[l].clone();
					ans =Math.max(solve(i, j, k, D, N, M), ans);
				}
			}
		}
		System.out.println(ans);
	}

	static int solve(int a, int b, int c, int D, int N, int M) {
		int result = 0;
		for (int t=N+1;t>0;) {
			int archer[] = {a,b,c};
			int select[] = {-1,-1,-1};
			for (int i = 0; i < 3; i++) {
				int d = Integer.MAX_VALUE;	//궁수와 적 사이의 거리
				for (int j = 0; j < M; j++) {
					if(clone[j].isEmpty()) continue;
					int newPosition=t-clone[j].peek(); //벽과 적사이의 거리
					int distance = (Math.abs(j - archer[i]) + newPosition); //해당 적과 궁수의 거리
					if (distance <= D && distance < d) {
						d=distance;
						select[i] = j;
					}
				}
			}
			boolean[] isSelected= new boolean[M];
			for (int i = 0; i < 3; i++) {
				if(select[i]!=-1) {
					if(isSelected[select[i]])continue; //동시에 같은적 공격시
					clone[select[i]].pop();
					result++;
					isSelected[select[i]]=true;
				}
			}
			boolean isEmpty = true;
			t--;
			for(int i=0;i<M;i++) {
				if(clone[i].isEmpty()) continue;
				isEmpty = false;
				if(clone[i].peek()==t) clone[i].pop();
			}
			if(isEmpty) break;
		}
		return result;
	}

}
