import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void read() throws IOException {
        st = new StringTokenizer(br.readLine());
    }
    static int nextInt(){
        return Integer.parseInt(st.nextToken());
    }

    public static class Point{
        int y;
        int x;
        Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    static int m, n;
    static int[][] graph;
    static Deque<Point> q = new LinkedList<>();
    static int[] dy = {1, 1, 1, 0, -1, -1, -1, 0};
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    
    public static void main(String[] args) throws IOException {
        read();
        m = nextInt();
        n = nextInt();
        graph = new int[m][n];

        for(int i=0; i<m; i++){
            read();
            for(int j=0; j<n; j++){
                graph[i][j] = nextInt();
                if(graph[i][j]==1) q.addFirst(new Point(i, j));
            }
        }

        while(!q.isEmpty()){
            Point node = q.pollLast();

            for(int i=0; i<8; i++){
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];

                if(ny >= 0 && ny < m && nx >= 0 && nx < n && graph[ny][nx]==0){
                    graph[ny][nx] = graph[node.y][node.x] + 1;
                    q.addFirst(new Point(ny, nx));
                }
            }
        }

        int max = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                max = Math.max(max, graph[i][j]);
            }
        }

        System.out.print(max-1);
    }
}