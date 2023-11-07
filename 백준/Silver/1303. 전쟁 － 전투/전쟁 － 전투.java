import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m, w=0, b=0;
    static char[][] graph;
    static boolean[][] visited; 

    static int dy[] = {1,-1,0,0};
    static int dx[] = {0,0,1,-1};

    public static class Point {
        int y;
        int x;
        Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    static void bfs(Point start, char color){
        Deque<Point> q = new LinkedList<>();
        q.addFirst(start);
        visited[start.y][start.x] = true;

        int cnt = 0;

        while(!q.isEmpty()){
            Point node = q.pollLast();
            cnt++;

            for(int i=0; i<4; i++){
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
    
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[ny][nx] && graph[ny][nx]==color){
                    q.addFirst(new Point(ny, nx));
                    visited[ny][nx] = true;
                }
            }
        }

        if(color=='W') w += cnt*cnt;
        else b += cnt*cnt;
    }
    
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new char[m][n];
        visited = new boolean[m][n];

        for(int i=0; i<m; i++) graph[i] = br.readLine().toCharArray();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    bfs(new Point(i, j), graph[i][j]);
                }
            }
        }

        System.out.print(w + " " + b);

        
    }
}