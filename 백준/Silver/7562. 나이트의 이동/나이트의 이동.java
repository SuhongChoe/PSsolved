import java.util.*;
import java.io.*;

public class Main {
    static int[] dy = {1,2,2,1,-1,-2,-2,-1};
    static int[] dx = {-2,-1,1,2,2,1,-1,-2};

    static boolean[][] visited;
    static Deque<int[]> q;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();

        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());

            q = new LinkedList<>();
            visited = new boolean[n][n];

            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            q.addFirst(new int[] {y, x, 0});
            visited[y][x] = true;

            st = new StringTokenizer(br.readLine());
            int endY = Integer.parseInt(st.nextToken());       
            int endX = Integer.parseInt(st.nextToken());

            while(!q.isEmpty()){
                int[] node = q.pollLast();

                if(node[0]==endY && node[1]==endX) {
                    sb.append(node[2]).append("\n");
                    break;
                }

                for(int i=0; i<8; i++){
                    int ny = dy[i] + node[0];
                    int nx = dx[i] + node[1];

                    if(0 <= ny && ny < n && 0 <= nx && nx < n && !visited[ny][nx]){
                        visited[ny][nx] = true;
                        q.addFirst(new int[] {ny, nx, node[2]+1});
                    }
                }
            }

        }

        System.out.print(sb);
    }
}