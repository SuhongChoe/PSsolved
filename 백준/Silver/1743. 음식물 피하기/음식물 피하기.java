import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static void read() throws IOException{
        st = new StringTokenizer(br.readLine());
    }
    static int nextInt() {
        return Integer.parseInt(st.nextToken());
    }

    public static class Point {
        int y;
        int x;
        Point(int a, int b){
            y = a;
            x = b;
        }
    }

    static int n, m, k, res;
    static int[][] graph;
    static boolean[][] visited;

    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,1,-1};

    static void bfs(Point start){
        Deque<Point> q = new LinkedList<>();
        visited[start.y][start.x] = true;
        q.addFirst(start);

        int cnt = 0;

        while(!q.isEmpty()){
            Point node = q.pollLast();
            cnt++;

            for(int i=0; i<4; i++){
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];

                if(0 <= ny && ny < m && 0 <= nx && nx < n && graph[ny][nx]==1 && !visited[ny][nx]){
                    q.addFirst(new Point(ny, nx));
                    visited[ny][nx] = true;
                }
            }
        }

        res = Math.max(res, cnt);
    }
    
    public static void main(String[] args) throws IOException{
        read();
        m = nextInt();
        n = nextInt();
        k = nextInt();
        graph = new int[m][n];
        visited = new boolean[m][n];

        for(int i=0; i<k; i++){
            read();
            graph[nextInt()-1][nextInt()-1] = 1;
        }

        res = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(graph[i][j]==1 && !visited[i][j]){
                    bfs(new Point(i, j));
                }
            }
        }

        System.out.print(res);
        
    }
}