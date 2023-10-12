import java.util.*;
import java.io.*;

public class Main {
    static int visited[];
    static ArrayList<Integer>[] graph;
    static int e, v;

    public static boolean isBipartiteGraph(){
        for (int node=1; node<v+1; node++){
            for(int next_node : graph[node]){
                if (visited[next_node] == visited[node]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void BFS(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 1;

        while(!q.isEmpty()){
            int node = q.poll();

            for(int next_node : graph[node]){
                if (visited[next_node] == 0){
                    visited[next_node] = visited[node]^3;
                    q.add(next_node);
                }
            }
        }
        
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuffer res = new StringBuffer();

        int k = Integer.parseInt(st.nextToken());

        while(k-- > 0){
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            graph = new ArrayList[v+1];
            for(int i=1; i<v+1; i++){
                graph[i] = new ArrayList<Integer>();
            }
            visited = new int[v+1];

            for(int i=0; i<e; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a].add(b);
                graph[b].add(a);
            }
            
            for(int i=1; i<v+1; i++) {
                if (visited[i]==0){
                    BFS(i);
                }
            }

            String tmp = (isBipartiteGraph()) ? "YES" : "NO";

            res.append(tmp).append("\n");
        }

        System.out.print(res);
    }
}