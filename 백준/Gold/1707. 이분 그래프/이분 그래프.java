import java.util.*;
import java.io.*;

public class Main {
    static int black = 0;
    static int red = 1;
    static int blue = 2;

    public static void BFS(int start, ArrayList<Integer>[] graph, int visited[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = red;

        while(!q.isEmpty()){
            int node = q.poll();

            for(int next_node : graph[node]){
                if (visited[next_node]==black){
                    visited[next_node] = visited[node]^3;
                    q.add(next_node);
                }
            }
        }
        
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuffer sb = new StringBuffer();

        int k = Integer.parseInt(st.nextToken());

        while(k-- > 0){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] graph = new ArrayList[v+1];
            for(int i=1; i<v+1; i++){
                graph[i] = new ArrayList<Integer>();
            }
            int visited[] = new int[v+1];

            for(int i=0; i<e; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a].add(b);
                graph[b].add(a);
            }
            
            for(int i=1; i<v+1; i++) {
                if (visited[i]==0) BFS(i, graph, visited);
            }

            String tmp = "YES";

            for(int node=1; node<v+1; node++){
                for(int next_node : graph[node]){
                    if (visited[next_node]==visited[node]){
                        tmp = "NO";
                        break;
                    }
                }
            }

            sb.append(tmp).append("\n");
        }

        System.out.print(sb);
    }
}