import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static boolean[][] visited = new boolean[100][100];
    // 동, 서, 남, 북
    // dy dx
    static int[] dy = {0,0,-1,1};
    static int[] dx = {1,-1,0,0};
    static double[] direct = new double[4];

    static double res = 1.0;

    public static void dfs(int y, int x, double prop, int cnt){
        if(cnt==n) return;
        
        for(int i=0; i<4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(visited[ny][nx]){ 
                res-=prop*direct[i];
            }
            else{
                visited[ny][nx] = true;
                dfs(ny, nx, prop*direct[i], cnt+1);
                visited[ny][nx] = false;
            }
        }
        
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        for(int i=0; i<4; i++) direct[i] = Integer.parseInt(st.nextToken()) * 0.01;
        
        visited[50][50] = true;      
        dfs(50, 50, 1.0, 0);

        System.out.println(res);
    }
}