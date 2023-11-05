import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void read() throws IOException{
        st = new StringTokenizer(br.readLine());
    }
    static int nextInt(){
        return Integer.parseInt(st.nextToken());
    }

    static int n, m;
    static int[] income;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException{
        read();
        n = nextInt();
        m = nextInt();
        income = new int[n+1];
        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++) graph[i] = new ArrayList<Integer>();

        for(int i=0; i<m; i++){
            read();
            int a = nextInt();
            int b = nextInt();
            graph[a].add(b);
            income[b]++;
        }

        Deque<Integer> q = new LinkedList<>();

        for(int i=1; i<=n; i++) if(income[i]==0) q.addFirst(i);

        StringBuffer sb = new StringBuffer();

        while(!q.isEmpty()){
            int node = q.pollLast();

            sb.append(node).append(" ");

            for(int next_node : graph[node]){
                income[next_node]--;
                if(income[next_node]==0){
                    q.addFirst(next_node);
                }
            }
        }

        System.out.print(sb);

    }
}
