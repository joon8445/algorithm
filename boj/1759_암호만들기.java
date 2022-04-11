import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static char[] word,pwd;
	static int L, C;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		word = new char[C];
		pwd = new char[L];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) {
			word[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(word);
		choice(0,0);
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}
	static void choice(int depth, int start) {
		if(depth == L) {
			int consonant=0,vowel=0;
			for(int i=0;i<L;i++) {
			if(pwd[i]=='a'||pwd[i]=='e'||pwd[i]=='i'||pwd[i]=='o'||pwd[i]=='u') vowel++;
			else consonant++;
			}
			String str = new String(pwd);
			if(vowel>0&&consonant>1) sb.append(str).append("\n");
			return;
		}
		for(int i=start;i<C;i++) {
			pwd[depth]= word[i];
			choice(depth+1,i+1);
		}
	}
}
