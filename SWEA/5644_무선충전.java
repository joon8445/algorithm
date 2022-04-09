import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static class bc{
		int i,j,range,power;
		public bc(int i,int j,int range,int power) {
			super();
			this.i=i;
			this.j=j;
			this.range=range;
			this.power=power;
		}
	}
	static int[][][] map;
	static int[][] move = {{0,0},{-1,0},{0,1},{1,0},{0,-1}}; 
	static int A,M;
	static boolean[] isUsed;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int ans=0;
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			M= Integer.parseInt(st.nextToken()); // 이동시간 M
			A= Integer.parseInt(st.nextToken()); // bc갯수 A
			int[] aMove = new int[M]; // a 이동경로
			int[] bMove = new int[M]; // b 이동경로
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) aMove[i]= Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) bMove[i]= Integer.parseInt(st.nextToken());
			bc[] ap = new bc[A];
			isUsed = new boolean[A];
			map= new int[11][11][A];
			for(int i=0;i<A;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int range = Integer.parseInt(st.nextToken());
				int power = Integer.parseInt(st.nextToken());
				ap[i] = new bc(y,x,range,power);
			}
			for(int i=0;i<11;i++) {
				for(int j=0;j<11;j++) {
					for(int k=0;k<A;k++) {
						if(Math.abs(ap[k].j-j)+Math.abs(ap[k].i-i)<=ap[k].range) {
							map[i][j][k]=ap[k].power; // 맵에는 충전가능한 전류들을 넣어줌.
						}
					}
				}
			}
			int[] aNow= {1,1};
			int[] bNow= {10,10};
			for(int i=0;i<M;i++) {
				ans+=charge(aNow[0],aNow[1],bNow[0],bNow[1]);//0~마지막 옮기기 전까지
				aNow[0]+=move[aMove[i]][0];
				aNow[1]+=move[aMove[i]][1];
				bNow[0]+=move[bMove[i]][0];
				bNow[1]+=move[bMove[i]][1];
			}
			ans+=charge(aNow[0],aNow[1],bNow[0],bNow[1]);//마지막 옮긴후
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
	static int charge(int ai,int aj,int bi,int bj) {
		int amax =0,bmax=0,sum=0;
		int tmp=-1;
		for(int i=0;i<A;i++) {
			if(map[ai][aj][i]>amax) {// 쓸수 있는 가장 큰 bc를 사용
				amax=map[ai][aj][i];
				tmp=i;
			}
		}
		if(tmp!=-1)	isUsed[tmp]=true;
		for(int i=0;i<A;i++) {	// a가 사용하지 않은 bc중에서 가장큰 bc 사용
			if(!isUsed[i]&&map[bi][bj][i]>bmax) {
				bmax=map[bi][bj][i];
			}
		}
		sum=amax+bmax;
		if(tmp!=-1) {// 두개 순서를 바꿔서 확인(a,b가 쓸수있는 bc리스트가 다를수 있기 때문에)
			isUsed[tmp]=false;
			int a=0,b=0,use=-1;
			for(int i=0;i<A;i++) {
				if(map[bi][bj][i]>b) {
					b=map[bi][bj][i];
					use=i;
				}
			}
			if(use!=-1)	isUsed[use]=true;
			for(int i=0;i<A;i++) {
				if(!isUsed[i]&&map[ai][aj][i]>a) {
					a=map[ai][aj][i];
				}
			}
			if(use!=-1)	isUsed[use]=false;
			sum = Math.max(sum, a+b);
		}
		
		return sum;
	}
}
