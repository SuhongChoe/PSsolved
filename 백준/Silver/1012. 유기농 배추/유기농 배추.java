import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int n, m, k;
    static int[][] graph;
    static boolean[][] visited;

    static int cnt;

    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};

    public static void bfs(int _y, int _x){
        Deque<int[]> q = new LinkedList<>();
        q.addFirst(new int[] {_y, _x});
        visited[_y][_x] = true;

        cnt++;

        while(!q.isEmpty()){
            int[] node = q.pollLast();

            for(int i=0; i<4; i++){
                int ny = dy[i] + node[0];
                int nx = dx[i] + node[1];

                if(0 <= ny && ny < m && 0 <= nx && nx < n && !visited[ny][nx] && graph[ny][nx]==1){
                    visited[ny][nx] = true;
                    q.addFirst(new int[] {ny, nx});
                }
            }
        }
    }
    
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();

        while(t-- > 0){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            graph = new int[m][n];
            visited = new boolean[m][n];

            while(k-- > 0){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[y][x] = 1;
            }

            cnt = 0;
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(graph[i][j]==1 && !visited[i][j]){
                        bfs(i, j);
                    }
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
        
    }
}