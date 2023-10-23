import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] graph;
    static int n, m, v;
    static boolean visited[];
    
    public static String bfs(int start){
        Deque<Integer> dq = new LinkedList<>();
        dq.addFirst(start);
        visited[start] = true;

        StringBuffer sb = new StringBuffer();

        while(!dq.isEmpty()){
            int node = dq.pollLast();
            sb.append(node).append(" ");

            for(int next_node : graph[node]){
                if(!visited[next_node]){
                    visited[next_node] = true;
                    dq.addFirst(next_node);
                }
            }
        }

        return sb.toString();
    }

    public static String dfs(int node){
        StringBuffer sb = new StringBuffer();
        visited[node] = true;
        sb.append(node).append(" ");
        for(int next_node : graph[node]){
            if (!visited[next_node]){
                sb.append(dfs(next_node));
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i=0; i<n+1; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i=0; i<n+1; i++){
            Collections.sort(graph[i]);
        }

        visited = new boolean[n+1];
        System.out.println(dfs(v));
        visited = new boolean[n+1];
        System.out.println(bfs(v));
    }
}