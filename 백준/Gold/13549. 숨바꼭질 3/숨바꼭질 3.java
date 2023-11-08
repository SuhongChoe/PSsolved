import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, k;
    static int[] visited;

    public static void bfs(){
        Deque<Integer> q = new LinkedList<>();
        q.addFirst(n);
        visited[n] = 0;
        
        while(!q.isEmpty()){
            int x = q.pollLast();

            for(int next_x=x<<1; next_x > 0 && next_x<=100000 && visited[next_x] == 100000; next_x <<= 1){
                visited[next_x] = visited[x];
                q.addFirst(next_x);
            }

            for(int next_x : new int[] {x-1, x+1}){
                if(next_x >= 0 && next_x<=100000 && visited[next_x] == 100000){
                    visited[next_x] = visited[x] + 1;
                    q.addFirst(next_x);
                }
            }
            
        }
    }
    
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new int[100001];
        Arrays.fill(visited, 100000);

        bfs();
        
        System.out.print(visited[k]);
        
    }
}