import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, k;
    static int[] visited;
    static int cnt = 0;
    static int time = 0;
    
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new int[100001];

        List<Integer> arr = new ArrayList<>();
        arr.add(n);
        
        while(true){
            for(int x : arr) visited[x]++;

            if(visited[k]!=0) break;
        
            List<Integer> tmp = new ArrayList<>();
            time++;

            for(int x : arr){
                for(int next_x : new int[] {x-1, x+1, x*2}){
                    if(next_x >= 0 && next_x <= 100000 && visited[next_x]==0){
                        tmp.add(next_x);
                    }
                }
            }
            arr.clear();
            for(int next_x : tmp) arr.add(next_x);
        }
        
        System.out.print(time + "\n" + visited[k]);
    }
}