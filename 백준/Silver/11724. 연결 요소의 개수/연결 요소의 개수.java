import java.util.*;
import java.io.*;

public class Main {
    static int parents [];
    
    public static int find(int x){
        if (parents[x] == x)
            return x;
        else{
            return parents[x] = find(parents[x]);
        }
    }

    public static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        
        if (aRoot > bRoot){
            parents[aRoot] = bRoot;
        } else if (aRoot < bRoot) {
            parents[bRoot] = aRoot;
        } else{
            return;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashSet<Integer> s = new HashSet<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n+1];

        for(int i=1; i<parents.length; i++) parents[i] = i;

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int aRoot = find(a);
            int bRoot = find(b);

            union(aRoot, bRoot);
        }

        for(int i=1; i<parents.length; i++) {
            find(i);
            s.add(parents[i]);
        }

        System.out.print(s.size());
    }

    // static boolean visited[];
    // static ArrayList<Integer> arr[];

    // public static void DFS(int node){
    //     visited[node] = true;
    //     for(int next_node : arr[node]){
    //         if (!visited[next_node]){
    //             DFS(next_node);
    //         }
    //     }
    // }

    // public static void main(String[] args) throws IOException {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     StringTokenizer st = new StringTokenizer(br.readLine());

    //     int n = Integer.parseInt(st.nextToken());
    //     int m = Integer.parseInt(st.nextToken());
    //     visited = new boolean[n+1];
    //     arr = new ArrayList[n+1];

    //     for(int i=1; i<n+1; i++){
    //         arr[i] = new ArrayList<Integer>();
    //     }

    //     for(int i=0; i<m; i++){
    //         st = new StringTokenizer(br.readLine());
    //         int a = Integer.parseInt(st.nextToken());
    //         int b = Integer.parseInt(st.nextToken());

    //         arr[a].add(b);
    //         arr[b].add(a);
    //     }

    //     int count = 0;

    //     for(int i=1; i<n+1; i++){
    //         if (!visited[i]){
    //             DFS(i);
    //             count++;
    //         }
    //     }
    //     System.out.print(count);
    // }
}