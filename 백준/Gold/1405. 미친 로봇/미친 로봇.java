import java.io.*;
import java.util.*;

//public class Main_1405{
//    static int n;
//    static boolean[][] visited = new boolean[100][100];
//    // �룞, �꽌, �궓, 遺�
//    // dy dx
//    static int[] dy = {0,0,-1,1};
//    static int[] dx = {1,-1,0,0};
//    static double[] direct = new double[4];
//
//    static double res = 1.0;
//
//    public static void dfs(int y, int x, double prop, int cnt){
//        if(cnt==n) return;
//        
//        for(int i=0; i<4; i++){
//            int ny = y + dy[i];
//            int nx = x + dx[i];
//            if(visited[ny][nx]){ 
//                res-=prop*direct[i];
//            }
//            else{
//                visited[ny][nx] = true;
//                dfs(ny, nx, prop*direct[i], cnt+1);
//                visited[ny][nx] = false;
//            }
//        }
//        
//    }
//    
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        n = Integer.parseInt(st.nextToken());
//        for(int i=0; i<4; i++) direct[i] = Integer.parseInt(st.nextToken()) * 0.01;
//        
//        visited[50][50] = true;      
//        dfs(50, 50, 1.0, 0);
//
//        System.out.println(res);
//    }
//}

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static void read() throws IOException{
		st = new StringTokenizer(br.readLine());
	}
	static int nextInt() {
		return Integer.parseInt(st.nextToken());
	}
	
	static void dfs(int cnt, int curY, int curX, double prop) {
		if(cnt==n) {
			res += prop;
			return;
		}
		for(int i=0; i<4; i++) {
			int nextY = curY + dy[i];
			int nextX = curX + dx[i];
			double nextProp = prop*d[i];
			
			if(!visited[nextY][nextX]) {
				visited[nextY][nextX] = true;
				dfs(cnt+1, nextY, nextX, nextProp);
				visited[nextY][nextX] = false;
			}
		}
	}
	
	static boolean[][] visited = new boolean[100][100];
	static double[] d = new double[4];
	static int n;
	static double res = 0;
	static int[] dy = {0,0,1,-1};
	static int[] dx = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException{
		read();
		n = nextInt();
		for(int i=0; i<4; i++) d[i] = (double) nextInt() / 100;

		for(int i=0; i<100; i++) Arrays.fill(visited[i], false);
		
		visited[50][50] = true;
		dfs(0, 50, 50, 1);
		
		System.out.print(res);
	}
}