import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
	static String[] answer = {"","Straight Flush","Four of a Kind","Full House","Flush","Straight","Three of a kind","Two pair","One pair","High card"};
	static int ans;
	static int[][] card;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			card =new int[5][2];
			for(int i=0;i<5;i++) {
				card[i]=toInteger(st.nextToken());
			}
			Arrays.sort(card, Comparator.comparingInt(o1->o1[1]));
			int ans =solve();
			sb.append(answer[ans]).append("\n");
		}
		System.out.println(sb.toString());
	}
	static int solve() {
		boolean suit = suit_check();
		boolean straight = straight_check();
		if(suit&&straight) return 1;
		int rank=rank_check();
		if(rank==4)return 2;
		if(rank==5)return 3;
		if(suit)return 4;
		if(straight) return 5;
		if(rank==3)return 6;
		if(rank==2) return 7;
		if(rank==1) return 8;
		return 9;
	}
	
	static int rank_check() {
		int cnt[] = new int[14];
		for(int i=0;i<5;i++) {
			cnt[card[i][1]]++;
		}
		Arrays.sort(cnt);
		if(cnt[13]==4) return 4;
		if(cnt[13]==3) {
			if(cnt[12]==2)return 5;
			return 3;
		}
		if(cnt[13]==2) {
			if(cnt[12]==2) return 2;
			return 1;
		}
		return 0;
	}
	static boolean straight_check() {
		if(card[1][1]==10) {
			for(int i=1;i<4;i++) {
				if(card[i][1]+1!=card[i+1][1]) return false;
			}
			if(card[0][1]!=1&&card[0][1]!=9)return false;
		}else {
			for(int i=0;i<4;i++) {
				if(card[i][1]+1!=card[i+1][1]) return false;
			}
		}
		return true;
	}
	
	static boolean suit_check() {
		int first = card[0][0];
		for(int i=1;i<5;i++) {
			if(first!=card[i][0]) return false;
		}
		return true;
	}
	
	static int[] toInteger(String str) {
		int[] arr = new int[2];
		char[] suit = str.substring(0, 1).toCharArray();
		arr[0] = (int)suit[0];
		String rank = str.substring(1, 2);
		switch (rank) {
		case "A":
			arr[1]=1;
			break;
		case "T":
			arr[1]=10;
			break;
		case "J":
			arr[1]=11;
			break;
		case "Q":
			arr[1]=12;
			break;
		case "K":
			arr[1]=13;
			break;
		default:
			arr[1]=Integer.parseInt(rank);
			break;
		}
		return arr;
	}
}
