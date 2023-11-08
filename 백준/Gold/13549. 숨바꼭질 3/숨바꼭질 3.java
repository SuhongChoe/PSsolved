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

            int next_x = x*2;
            while(next_x<=100000 && visited[next_x]>visited[x]){
                visited[next_x] = visited[x];
                q.add(next_x);
                next_x *= 2;
            }

            for(int next_x2 : new int[] {x-1, x+1}){
                if(next_x2 >= 0 && next_x2<=100000 && visited[next_x2]>visited[x]+1){
                    visited[next_x2] = visited[x] + 1;
                    q.add(next_x2);
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
        
        // for(int i=0; i<=k; i++) System.out.print(visited[i] + " ");
        
    }
}