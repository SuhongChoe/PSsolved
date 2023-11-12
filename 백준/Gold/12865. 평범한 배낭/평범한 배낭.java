import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void read() throws IOException {
        st = new StringTokenizer(br.readLine());
    }
    static int nextInt() {
        return Integer.parseInt(st.nextToken());
    }

    static int n, k;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        read();
        n = nextInt();
        k = nextInt();
        dp = new int[n+1][k+1];

        for(int i=1; i<=n; i++){
            read();
            int w = nextInt();
            int v = nextInt();
            for(int j=1; j<=k; j++){
                if(w<=j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.print(dp[n][k]);
    }
}
