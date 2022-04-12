import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[] light;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		light = new boolean[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp==1) light[i]=true;
		}
		int studNum = Integer.parseInt(br.readLine());
		for(int i=0;i<studNum;i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			if(gender == 1) {
				man(Integer.parseInt(st.nextToken()));
			}
			else {
				woman(Integer.parseInt(st.nextToken()));
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=N;i++) {
			if(light[i]) sb.append(1).append(" ");
			else sb.append(0).append(" ");
			if(i%20==0) sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	static void man(int num) {
		for(int i=num;i<=N;i+=num) {
			light[i] = !light[i];
		}
	}
	static void woman(int num) {
		light[num] = !light[num];
		for(int i=1;i<num;i++) {
			if(num+i<=N&&light[num-i]==light[num+i]) {
				light[num-i] = !light[num-i];
				light[num+i] = !light[num+i];
			}
			else return;
		}
	}
	
}
