import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int n;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};

    public static void bfs(int _y, int _x){
        Deque<int[]> q = new LinkedList<>();
        q.addFirst(new int[] {_y, _x});
        visited[_y][_x] = true;

        int cnt = 0;

        while (!q.isEmpty()){
            int[] node = q.pollLast();
            cnt++;

            for(int i=0; i<4; i++){
                int ny = dy[i] + node[0];
                int nx = dx[i] + node[1];

                if (0 <= nx && nx < n && 0 <= ny && ny < n && !visited[ny][nx] && graph[ny][nx]==1){
                    q.addFirst(new int[] {ny, nx});
                    visited[ny][nx] = true;
                }
            }
        }
        pq.add(cnt);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            char[] c = br.readLine().toCharArray();
            for(int j=0; j<n; j++){
               graph[i][j] = c[j] - '0';
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if (graph[i][j]==1 && !visited[i][j]){
                    bfs(i, j);
                }
            }
        }
        StringBuffer sb = new StringBuffer();

        sb.append(pq.size()).append("\n");
        while(!pq.isEmpty()){
            sb.append(pq.poll()).append("\n");
        }

        System.out.print(sb);

    }
}
