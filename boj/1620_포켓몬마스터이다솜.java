import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<Integer, String> str = new HashMap<>(N);
		HashMap<String, Integer> num = new HashMap<>(N);
		for(int i=1;i<=N;i++) {
			String name = br.readLine();
			str.put(i, name);
			num.put(name,i);
		}
		for(int i=0;i<M;i++) {
			String tmp = br.readLine();
			if(tmp.charAt(0)<='Z'&&tmp.charAt(0)>='A') {
				sb.append(num.get(tmp)).append("\n");
			}else {
				sb.append(str.get(Integer.parseInt(tmp))).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
