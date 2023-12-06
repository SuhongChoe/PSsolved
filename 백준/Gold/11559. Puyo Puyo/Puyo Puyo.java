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
	
	static char[][] field = new char[6][12];
	static boolean[][] visited;
	
	public static class Point {
		int y;
		int x;
		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static int[] dy = {0,0,1,-1};
	static int[] dx = {1,-1,0,0};
	
	static boolean bfs(Point start, char color) {
		Deque<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[6][12];
		
		q.addFirst(start);
		visited[start.y][start.x] = true;
		
		int cnt = 0;
		
		while(!q.isEmpty()) {
			Point node = q.pollLast();
			cnt++;
			
			for(int i=0; i<4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				
				if(ny >= 0 && ny < 6 && nx >=0 && nx < 12 && !visited[ny][nx] && color==field[ny][nx]) {
					q.addFirst(new Point(ny, nx));
					visited[ny][nx] = true;
				}
			}
		}
		
		if(cnt>=4) {
			for(int i=0; i<6; i++) {
				for(int j=0; j<12; j++) {
					if(visited[i][j]) {
						field[i][j] = '.';
					}
				}
			}
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) throws IOException{
		for(int i=11; i>=0; i--) {
			read();
			char[] tmp = st.nextToken().toCharArray();
			for(int j=0; j<6; j++) {
				field[j][i] = tmp[j]; 
			}
		}
		
		int cnt = 0;
		boolean isContinue = true;
		
		while(isContinue) {
			isContinue = false;
			
			for(int i=0; i<6; i++) {
				for(int j=0; j<12; j++) {
					if(field[i][j]!='.' && bfs(new Point(i,j), field[i][j])){
						if(!isContinue) {
							isContinue = true;
							cnt++;
						}
						
						
					}
				}
			}
			
			for(int y=0; y<6; y++) {
				Deque<Character> newFloor = new LinkedList<>();
				for(int x=0; x<12; x++) {
					if(field[y][x]!='.') {
						newFloor.addLast(field[y][x]);
					}	
				}
				
				while(newFloor.size()<12) {
					newFloor.addLast('.');
				}
				
				while(!newFloor.isEmpty()) {
					field[y][newFloor.size()-1]= newFloor.pollLast();
				}
			}			
		}
		
		System.out.print(cnt);
		
	}

}
