import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static long[] dp;
    
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        dp = new long[n+1];

        for(int i=1; i<=n; i++){
            dp[i] = dp[i-1] + 1;
            for(int j=3; j<i; j++){
                dp[i] = Math.max(dp[i-j]*(j-1), dp[i]);
            }
        }
        
        // for(int i=1; i<=n; i++) System.out.print(dp[i] + " ");
        
        System.out.print(dp[n]);
    }
}