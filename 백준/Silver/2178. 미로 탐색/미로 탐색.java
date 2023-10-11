import java.util.*;
import java.io.*;

class Node {
    private int y;
    private int x;
    private int cnt;
    Node(int y, int x, int cnt){
        this.y = y;
        this.x = x;
        this.cnt = cnt;
    }

    public int getY(){
        return y;
    }
    public int getX(){
        return x;
    }
    public int getCnt(){
        return cnt;
    }

}

public class Main {
    static boolean visited[][];
    static char graph[][];
    static int m;
    static int n;

    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};

    public static int BFS(Node start){
        Queue<Node> q = new LinkedList<>();

        q.add(start);
        visited[start.getY()][start.getX()] = true;

        int res = 0;

        while (!q.isEmpty()){
           Node node = q.poll();

           if (node.getY()==m-1 && node.getX()==n-1) {
               res = node.getCnt();
               break;
           }

           for(int i=0; i<4; i++){
               int ny = node.getY() + dy[i];
               int nx = node.getX() + dx[i];

               if (0 <= nx && nx < n && 0 <= ny && ny < m && graph[ny][nx]=='1' && !visited[ny][nx]){
                    q.add(new Node(ny, nx, node.getCnt()+1));
                    visited[ny][nx] = true;
               }

           }
        }

        return res;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        graph = new char[m][n];
        visited = new boolean[m][n];


        for(int i=0; i<m; i++){
            graph[i] = br.readLine().toCharArray();
        }

        int res = BFS(new Node(0,0,1));

        System.out.print(res);
    }
}
