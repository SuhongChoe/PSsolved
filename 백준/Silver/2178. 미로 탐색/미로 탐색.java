import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,1,-1};

    public static class Point {
        int y;
        int x;
        int cnt = 0;
        Point(int a, int b, int c){
            y=a;
            x=b;
            cnt=c;
        }
    }

    public static int bfs(Point start){
        Deque<Point> q = new LinkedList<>();
        q.addFirst(start);
        visited[start.y][start.x] = true;

        int res=0;

        while(!q.isEmpty()){
            Point node = q.pollLast();
            
            if(node.x==n-1 && node.y==m-1){
                res = node.cnt;
                break;
            }

            for(int i=0; i<4; i++){
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
                
                if(0 <= nx && nx < n && 0 <= ny && ny < m && graph[ny][nx]=='1' && !visited[ny][nx]){
                    q.addFirst(new Point(ny, nx, node.cnt+1));
                    visited[ny][nx] = true;
                }
            }
        }
        
        return res;
    }

    static int m, n;
    static char[][] graph;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        graph = new char[m][n];
        visited = new boolean[m][n];

        for(int i=0; i<m; i++) graph[i] = br.readLine().toCharArray();

        int res = bfs(new Point(0, 0, 1));

        System.out.print(res);
        
    }
}