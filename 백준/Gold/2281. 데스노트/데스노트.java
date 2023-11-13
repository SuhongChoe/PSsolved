import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int dfs(int idx){
        if(dp[idx]<Integer.MAX_VALUE) return dp[idx];
        int remain = m - arr[idx];
        for(int i=idx+1; i<=n && remain>=0; i++){
            if(i==n){
                dp[idx] = 0;
                break;
            }
            dp[idx] = Math.min(dp[idx], remain*remain+dfs(i));
            remain -= arr[i] + 1;
        }
        return dp[idx];
    }

    static int n, m;
    static int[] arr, dp;
    
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n-1] = 0;
        
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(br.readLine());

        System.out.print(dfs(0));
        
    }
}