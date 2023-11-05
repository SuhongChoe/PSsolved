import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void read() throws IOException{
        st = new StringTokenizer(br.readLine());
    }

    static int nextInt() {
        return Integer.parseInt(st.nextToken());
    }

    static int n, k;
    static int[] arr;
    static long[] dp;

    public static void main(String[] args) throws IOException{
        read();
        n = nextInt();
        k = nextInt();
        arr = new int[n];
        dp = new long[k+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        for(int coin : arr){
            for(int i=coin; i<=k; i++){
                dp[i] = Math.min(dp[i-coin]+1, dp[i]);
            }
        }

        System.out.print(dp[k]==Integer.MAX_VALUE ? -1 : dp[k]);
    }
}
