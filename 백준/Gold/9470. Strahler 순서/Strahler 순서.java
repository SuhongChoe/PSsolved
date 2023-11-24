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

    static List<Integer>[] graph;
    static int[] strahler, conv;
    static int k, m, p;
    
    public static void main(String[] args) throws IOException{
        read();
        int T = nextInt();

        StringBuffer sb = new StringBuffer();
        
        while(T-- > 0){
            read();
            k = nextInt();
            m = nextInt();
            p = nextInt();

            graph = new ArrayList[m+1];

            for(int i=1; i<=m; i++){ 
                graph[i] = new ArrayList<Integer>();
            }

            conv = new int[m+1];

            for(int i=0; i<p; i++){
                read();
                int a = nextInt();
                int b = nextInt();
                graph[a].add(b);
                graph[b].add(a);
                conv[b]++;
            }
            
            Deque<Integer> q = new LinkedList<>();
            strahler = new int[m+1];

            for(int i=1; i<=m; i++){
                if(conv[i]==0){
                    strahler[i] = 0;
                    q.addFirst(i);
                }
            }

            while(!q.isEmpty()){
                int node = q.pollLast();

                int maxStrahler = 0;
                for(int pre_node : graph[node]){
                    if(conv[pre_node]<=0){
                        maxStrahler = Math.max(strahler[pre_node], maxStrahler);
                    }
                }

                int cnt = 0;
                for(int pre_node : graph[node]){
                    if(conv[pre_node]<=0 && maxStrahler==strahler[pre_node]){
                        cnt++;
                    }
                }
                
                strahler[node] = (cnt==1) ? maxStrahler : maxStrahler+1;

                for(int next_node : graph[node]){
                    conv[next_node]--;
                    if(conv[next_node]==0){
                        q.addFirst(next_node);
                    }
                }
            }

            int res = 0;
            for(int i=1; i<=m; i++) res = Math.max(res, strahler[i]);

            sb.append(k).append(" ").append(res).append("\n");
        }
        
        System.out.print(sb);
    }
}