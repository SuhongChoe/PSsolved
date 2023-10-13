import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int in[];
    static ArrayList<Integer> graph[];
    static StringBuffer sb;

    public static void topology_sort(){
        Queue<Integer> q = new LinkedList<>();
        sb = new StringBuffer(n*2);

        for(int i=1; i<n+1; i++){
            if (in[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();

            sb.append(node).append(" ");

            for(int next_node : graph[node]){
                in[next_node]--;
                if (in[next_node]==0) q.add(next_node);
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        in = new int[n+1];
        graph = new ArrayList[n+1];
        for(int i=0; i<n+1; i++){
            graph[i] = new ArrayList<>();
        }

        while(m-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());            
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            in[b]++;
        }

        topology_sort();

        System.out.print(sb);

    }
}