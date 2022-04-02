import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t < 11; t++) {
			Stack<Character> bracket = new Stack<Character>();
			int n = sc.nextInt();
			char[] ch = sc.next().toCharArray();
			for (int i = 0; i < n; i++) {
				switch (ch[i]) {
				case '[':
					bracket.push(ch[i]);
					break;
				case '{':
					bracket.push(ch[i]);
					break;
				case '(':
					bracket.push(ch[i]);
					break;
				case '<':
					bracket.push(ch[i]);
					break;
				case ']':
					if(!bracket.isEmpty()&&'['!=bracket.pop()) {
						bracket.push(ch[i]);
						i=n;
					}
					break;
				case '}':
					if(!bracket.isEmpty()&&'{'!=bracket.pop()) {
						bracket.push(ch[i]);
						i=n;
					}
					break;
				case ')':
					if(!bracket.isEmpty()&&'('!=bracket.pop()) {
						bracket.push(ch[i]);
						i=n;
					}
					break;
				case '>':
					if(!bracket.isEmpty()&&'<'!=bracket.pop()) {
						bracket.push(ch[i]);
						i=n;
					}
					break;
				default:
					break;
				}
			}
			
			System.out.printf("#%d %d\n",t,bracket.isEmpty()?1:0);

		}
	}
}
