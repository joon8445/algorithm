package study.심심;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb= new StringBuilder();
			String a = sb.append(st.nextToken()).reverse().toString();
			sb = new StringBuilder();
			String b = sb.append(st.nextToken()).reverse().toString();
			
			sb = new StringBuilder();
			String ans = sb.append(add(a,b)).reverse().toString();
			System.out.println(ans);
		}
	}

	static String add(String a, String b) {
		int length = Math.max(a.length(), b.length());
		a+="000000000000000000000000000000000000000000000000000000000000000000000000000000000";
		b+="000000000000000000000000000000000000000000000000000000000000000000000000000000000";
		char[] ans= new char[length+1];
		String tmp ="0";
		for(int i=0;i<=length;i++) {
			String aNow=a.substring(i,i+1);
			String bNow=b.substring(i,i+1);
			if(tmp.equals("0")) {
				if(aNow.equals(bNow)) {
					ans[i]='0';
					if(aNow.equals("1")) {
						tmp="1";
					}
				}else {
					ans[i]='1';
					tmp="0";
				}
			}else {
				if(aNow.equals("1")||bNow.equals("1")) {
					tmp="1";
				}else {
					tmp="0";
				}
				if(aNow.equals(bNow)) {
					ans[i]='1';
				}else {
					ans[i]='0';
				}
			}
		}
		String str = new String(ans);
		return zeroCut(str);
	}
	static String zeroCut(String str) {
		for(int i=str.length()-1;i>=0;i--) {
			if(str.substring(i,i+1).equals("1")) {
				str=str.substring(0,i+1);
				return str;
			}
		}
		return "0";
	}
}
