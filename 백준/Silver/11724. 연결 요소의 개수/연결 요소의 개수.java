import java.util.*;
import java.io.*;

public class Main {
    // static int[] parent;
    
    // public static int find(int x){
    //     if (parent[x] == x) return x;
    //     return parent[x] = find(parent[x]);
    // }

    // public static void union(int aRoot, int bRoot){
    //     if (aRoot > bRoot) parent[aRoot] = bRoot;
    //     else parent[bRoot] = aRoot;
    // }
    
    // public static void main(String[] args) throws IOException {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     StringTokenizer st = new StringTokenizer(br.readLine());

    //     HashSet<Integer> s = new HashSet<>();

    //     int n = Integer.parseInt(st.nextToken());
    //     int m = Integer.parseInt(st.nextToken());

    //     parent = new int[n+1];

    //     for(int i=1; i<parent.length; i++) parent[i] = i;

    //     for(int i=0; i<m; i++){
    //         st = new StringTokenizer(br.readLine());
    //         int a = Integer.parseInt(st.nextToken());
    //         int b = Integer.parseInt(st.nextToken());

    //         int aRoot = find(a);
    //         int bRoot = find(b);
            
    //         if(aRoot!=bRoot) union(aRoot, bRoot);
    //     }

    //     for(int i=1; i<parent.length; i++) s.add(parent[i]);

    //     System.out.print(s.size());
    // }

    static boolean visited[];
    static ArrayList<Integer>[] arr;

    public static void DFS(int node){
        visited[node] = true;
        for(int next_node : arr[node]){
            if (!visited[next_node]){
                DFS(next_node);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        arr = new ArrayList[n+1];

        for(int i=1; i<n+1; i++){
            arr[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        int count = 0;

        for(int i=1; i<n+1; i++){
            if (!visited[i]){
                DFS(i);
                count++;
            }
        }

        System.out.print(count);

    }

}