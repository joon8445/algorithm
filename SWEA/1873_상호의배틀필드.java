import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			char[][] map = new char[H][W];
			int[] tank = new int[3];
			for (int i = 0; i < H; i++) {
				map[i] = sc.next().toCharArray();
				for (int j = 0; j < W; j++) {
					if (map[i][j] == '^') {
						tank[0] = 1;
						tank[1] = i;
						tank[2] = j;
						map[i][j] = '.';
					} else if (map[i][j] == 'v') {
						tank[0] = 2;
						tank[1] = i;
						tank[2] = j;
						map[i][j] = '.';
					} else if (map[i][j] == '<') {
						tank[0] = 3;
						tank[1] = i;
						tank[2] = j;
						map[i][j] = '.';
					} else if (map[i][j] == '>') {
						tank[0] = 4;
						tank[1] = i;
						tank[2] = j;
						map[i][j] = '.';
					}
				}
			}
			int N = sc.nextInt();
			char[] command = sc.next().toCharArray();
			for (int i = 0; i < N; i++) {
				switch (command[i]) {
				case 'U':
					tank[0] = 1;
					if (tank[1] > 0 && map[tank[1] - 1][tank[2]] == '.') {
						tank[1]--;
					}
					break;
				case 'D':
					tank[0] = 2;
					if (tank[1] < H - 1 && map[tank[1] + 1][tank[2]] == '.') {
						tank[1]++;
					}
					break;
				case 'L':
					tank[0] = 3;
					if (tank[2] > 0 && map[tank[1]][tank[2] - 1] == '.') {
						tank[2]--;
					}
					break;
				case 'R':
					tank[0] = 4;
					if (tank[2] < W - 1 && map[tank[1]][tank[2] + 1] == '.') {
						tank[2]++;
					}
					break;
				case 'S':
					switch (tank[0]) {
					case 1:
						for (int j = tank[1]; j >= 0; j--) {
							if(map[j][tank[2]] == '#') break;
							if (map[j][tank[2]] == '*') {
								map[j][tank[2]] = '.';
								break;
							}
						}
						break;
					case 2:
						for (int j = tank[1]; j < H; j++) {
							if(map[j][tank[2]] == '#') break;
							if (map[j][tank[2]] == '*') {
								map[j][tank[2]] = '.';
								break;
							}
						}
						break;
					case 3:
						for (int j = tank[2]; j >= 0; j--) {
							if(map[tank[1]][j] == '#') break;
							if (map[tank[1]][j] == '*') {
								map[tank[1]][j] = '.';
								break;
							}
						}
						break;
					case 4:
						for (int j = tank[2]; j < W; j++) {
							if(map[tank[1]][j] == '#') break;
							if (map[tank[1]][j] == '*') {
								map[tank[1]][j] = '.';
								break;
							}
						}
						break;
					default:
						break;
					}
					break;
				default:
					break;
				}
			}
			switch (tank[0]) {
			case 1:
				map[tank[1]][tank[2]] = '^';
				break;
			case 2:
				map[tank[1]][tank[2]] = 'v';
				break;
			case 3:
				map[tank[1]][tank[2]] = '<';
				break;
			case 4:
				map[tank[1]][tank[2]] = '>';
				break;

			default:
				break;
			}
			System.out.printf("#%d ",t+1);
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++){
					System.out.printf("%c",map[i][j]);
				}
				System.out.println();
			}
			
		}
		sc.close();
	}
}
