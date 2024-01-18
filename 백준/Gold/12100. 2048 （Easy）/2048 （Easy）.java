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
	
	static int n;
	static int res=0;
	
	static void dfs(int board[][], int cnt) {
		if(cnt==5) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					res = Math.max(res, board[i][j]);
				}
			}
			return;
		}
		
		for(int d=0; d<4; d++) {
			int[][] rotated = rotate(board);
			int[][] converted = convert(rotated);
			
			dfs(convert(rotated),cnt+1);
			
			for(int i=0; i<n; i++) {
				board[i] = rotated[i].clone();
			}
		}
	}
	
	static int[][] convert(int[][] board) {
		int[][] converted = new int[n][n];
		
		for(int i=0; i<n; i++) {
			ArrayList<Integer> newArr = new ArrayList<>();
			ArrayList<Integer> newArr2 = new ArrayList<>();
			
			for(int j=0; j<n; j++) {
				if(board[i][j]!=0) {
					newArr.add(board[i][j]);
				}
			}
			
			for(int j=1; j<newArr.size(); j++) {
				if(newArr.get(j-1).equals(newArr.get(j))) {
					newArr.set(j-1, newArr.get(j-1)+newArr.get(j));
					newArr.set(j, 0);
				}
			}
			
			for(int j=0; j<newArr.size(); j++) {
				if(!newArr.get(j).equals(0)) {
					newArr2.add(newArr.get(j));
				}
			}
			
			Arrays.fill(converted[i], 0);
			for(int j=0; j<newArr2.size(); j++) {
				converted[i][j] = newArr2.get(j);
			}
		}
		
		return converted;
	}
	
	static int[][] rotate(int[][] board){
		int[][] rotated = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				rotated[j][n-1-i] = board[i][j];
			}
		}
		
		return rotated;
	}
	
	

	public static void main(String[] args) throws IOException{
		read();
		n = nextInt();
		int[][] board = new int[n][n];
		for(int i=0; i<n; i++) {
			read();
			for(int j=0; j<n; j++) {
				board[i][j] = nextInt();
			}
		}
		
		dfs(board, 0);
		
		System.out.print(res);
	}
}