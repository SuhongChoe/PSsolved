import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, res;
    static long[][] dp;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        dp = new long[n-1][21];
        st = new StringTokenizer(br.readLine());


        res = Integer.parseInt(st.nextToken());
        dp[0][res] = 1;

        for(int i=1; i<n-1; i++) {
            int curNum = Integer.parseInt(st.nextToken());
            for (int j = 0; j <= 20; j++) {
                if (j + curNum <= 20) {
                    dp[i][j] += dp[i - 1][j+curNum];
                }
                if (j - curNum >= 0) {
                    dp[i][j] += dp[i - 1][j-curNum];
                }
            }
        }

        System.out.print(dp[n-2][Integer.parseInt(st.nextToken())]);
    }
}
