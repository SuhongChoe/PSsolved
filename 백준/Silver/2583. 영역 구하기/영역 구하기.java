import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k; //가로, 세로, 영역 개수
    static int[][] graph;
    static boolean[][] visited;
    static PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2)->(n1-n2));

    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};

    public static int bfs(int _y, int _x){
        Deque<int[]> q = new LinkedList<>();
        q.addFirst(new int[] {_y, _x});
        visited[_y][_x] = true;

        int cnt = 0;

        while(!q.isEmpty()){
            int[] node = q.pollLast();
            cnt++;
            
            for(int i=0; i<4; i++){
                int ny = dy[i] + node[0];
                int nx = dx[i] + node[1];

                if(0 <= nx && nx < n && 0 <= ny && ny < m && graph[ny][nx]==0 && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    q.addFirst(new int[] {ny, nx});
                }
            }
        }

        return cnt;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new int[m][n];
        visited = new boolean[m][n];

        while(k-- > 0){
            st = new StringTokenizer(br.readLine());
            int s_x = Integer.parseInt(st.nextToken());
            int s_y = Integer.parseInt(st.nextToken());
            int e_x = Integer.parseInt(st.nextToken());
            int e_y = Integer.parseInt(st.nextToken());

            for(int i=s_y; i<e_y; i++){
                for(int j=s_x; j<e_x; j++){
                    graph[i][j] = 1;
                }
            }
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(graph[i][j]==0 && !visited[i][j]){
                    pq.add((bfs(i, j)));
                }
            }
        }

        StringBuffer sb = new StringBuffer();

        sb.append(pq.size()).append("\n");

        while(!pq.isEmpty()){
            sb.append(pq.poll()).append(" ");
        }

        System.out.print(sb);
    }
}