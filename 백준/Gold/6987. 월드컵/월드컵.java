import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static void read() throws IOException{
		st = new StringTokenizer(br.readLine());
	}
	static int nextInt() {
		return Integer.parseInt(st.nextToken());
	}
	
	static int[][] matches = new int[15][2];
	static int[][] scores = new int[6][3];
	static boolean isPos;
	
	static void dfs(int index) {
		if(isPos) return;
		
		if(index==15) {
			isPos = true;
			return;
		}
		
		int aTeam = matches[index][0];
		int bTeam = matches[index][1];
		
		// win draw
		if(scores[aTeam][0]>0 && scores[bTeam][2]>0) {
			scores[aTeam][0]--;
			scores[bTeam][2]--;
			dfs(index+1);
			scores[aTeam][0]++;
			scores[bTeam][2]++;
		}
		
		// draw draw
		if(scores[aTeam][1]>0 && scores[bTeam][1]>0) {
			scores[aTeam][1]--;
			scores[bTeam][1]--;
			dfs(index+1);
			scores[aTeam][1]++;
			scores[bTeam][1]++;
		}
		
		// lose win
		if(scores[aTeam][2]>0 && scores[bTeam][0]>0) {
			scores[aTeam][2]--;
			scores[bTeam][0]--;
			dfs(index+1);
			scores[aTeam][2]++;
			scores[bTeam][0]++;
		}
	}
	
	public static void main(String[] args) throws IOException{
		int n = 4;
		StringBuffer sb = new StringBuffer();
		
		while(n-- > 0) {
			int index = 0;
			for(int i=0; i<5; i++) {
				for(int j=i+1; j<6; j++) {
					matches[index][0] = i;
					matches[index][1] = j;
					index++;
				}
			}
			
			read();
			for(int i=0; i<6; i++) {
				for(int j=0; j<3; j++) {
					scores[i][j] = nextInt();
				}
			}
			
			isPos = false;
			
			dfs(0);
			
			for(int i=0; i<6; i++) {
				int tmp=0;
				for(int j=0; j<3; j++) {
					tmp += scores[i][j];
				}
				if(tmp!=5) isPos = false;
			}
			
			sb.append((isPos) ? "1 " : "0 ");
			
		}
		
		System.out.print(sb);
	}
}
