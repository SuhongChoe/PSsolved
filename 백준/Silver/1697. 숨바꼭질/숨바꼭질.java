import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int target;

    public static boolean check(int x){
        return (0 <= x && x <= 100000);
    }
    
    public static int bfs(int start){
        Deque<int[]> dq = new LinkedList<>();
        boolean visited[] = new boolean[100001];
        int res = 0;
        
        dq.addFirst(new int[] {start, 0});
        visited[start] = true;
        

        while(!dq.isEmpty()){
            int cur[] = dq.pollLast(); // point, time

            if(cur[0]==target){
                res = cur[1];
                break;
            }

            int arr[] = {cur[0]-1, cur[0]+1, cur[0]*2};

            for(int x : arr){
                if(check(x) && !visited[x]){
                    visited[x] = true;
                    dq.addFirst(new int[] {x, cur[1]+1});
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        int res = bfs(n);

        System.out.print(res);        
    }
}