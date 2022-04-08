import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map,tmp;
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		tmp = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int rotateCase = Integer.parseInt(st.nextToken());
			switch (rotateCase) {
			case 1:
				rotation1();
				break;
			case 2:
				rotation2();
				break;
			case 3:
				rotation3();
				break;
			case 4:
				rotation4();
				break;
			case 5:
				rotation5();
				break;
			case 6:
				rotation6();
				break;
			default:
				break;
			}
		}
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++)
				sb.append(map[i][j]).append(" ");
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	static void arrClone() {
		tmp = new int[map.length][map[0].length];
		for(int i=0;i<map.length;i++) {
			tmp[i]=map[i].clone();
		}
	}
	static void rotation1() {
		arrClone();
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				map[i][j]=tmp[map.length-i-1][j];
			}
		}
	}
	static void rotation2() {
		arrClone();
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				map[i][j]=tmp[i][map[i].length-j-1];
			}
		}
	}
	static void rotation3() { // 배열 전치후 좌우 반전
		arrClone();
		map = new int [tmp[0].length][tmp.length];
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				map[i][j]=tmp[j][i];
			}
		}
		rotation2();
	}
	static void rotation4() { // 배열 전치후 상하 반전
		arrClone();
		map = new int [tmp[0].length][tmp.length];
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				map[i][j]=tmp[j][i];
			}
		}
		rotation1();
	}
	static void rotation5() {
		arrClone();
		for(int i=0;i<map.length/2;i++) {
			for(int j=0;j<map[i].length/2;j++) {
				map[i][j] = tmp[i+map.length/2][j];
			}
			for(int j=map[i].length/2;j<map[i].length;j++) {
				map[i][j] = tmp[i][j-map[i].length/2];
			}
		}
		for(int i=map.length/2;i<map.length;i++) {
			for(int j=0;j<map[i].length/2;j++) {
				map[i][j] = tmp[i][j+map[i].length/2];
			}
			for(int j=map[i].length/2;j<map[i].length;j++) {
				map[i][j] = tmp[i-map.length/2][j];
			}
		}
	}
	static void rotation6() {
		arrClone();
		for(int i=0;i<map.length/2;i++) {
			for(int j=0;j<map[i].length/2;j++) {
				map[i][j] = tmp[i][j+map[i].length/2];
			}
			for(int j=map[i].length/2;j<map[i].length;j++) {
				map[i][j] = tmp[i+map.length/2][j];
			}
		}
		for(int i=map.length/2;i<map.length;i++) {
			for(int j=0;j<map[i].length/2;j++) {
				map[i][j] = tmp[i-map.length/2][j];
			}
			for(int j=map[i].length/2;j<map[i].length;j++) {
				map[i][j] = tmp[i][j-map[i].length/2];
			}
		}
	}
}
