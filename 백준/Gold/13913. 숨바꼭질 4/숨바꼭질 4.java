import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, k;
    static int[] visited;

    static void bfs(){
        Deque<Integer> q = new LinkedList<>();
        q.addFirst(n);
        visited[n] = n;

        while(!q.isEmpty()){
            int x = q.pollLast();

            for(int next_x : new int[] {x-1, x+1, x*2}){
                if(next_x >= 0 && next_x <= 100000 && visited[next_x]==100001){
                    visited[next_x] = x;
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
        Arrays.fill(visited, 100001);

        Deque<Integer> res = new LinkedList<>();
        StringBuffer sb = new StringBuffer();

        bfs();

        for(int tmp=k; tmp!=n; tmp=visited[tmp]) res.addLast(tmp);
        res.addLast(n);

        sb.append(res.size()-1).append("\n");
        while(!res.isEmpty()) sb.append(res.pollLast()).append(" ");

        System.out.print(sb);
        
    }
}