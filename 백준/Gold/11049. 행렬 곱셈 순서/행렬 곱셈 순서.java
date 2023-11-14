import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void read() throws IOException {
        st = new StringTokenizer(br.readLine());
    }
    static int nextInt(){
        return Integer.parseInt(st.nextToken());
    }

    static int n;
    static int[][] mat, dp;
    
    public static void main(String[] args) throws IOException {
        read();
        n = nextInt();
        mat = new int[n][2];
        dp = new int[n][n];
        
        for(int i=0; i<n; i++){
            read();
            mat[i][0] = nextInt();
            mat[i][1] = nextInt();
        }

        for(int i=1; i<n; i++){
            for(int j=0; i+j<n; j++){
                dp[j][i+j] = Integer.MAX_VALUE;
                for(int k=0; k<i; k++){
                    dp[j][i+j] = Math.min(dp[j][i+j], dp[j][j+k] + dp[j+k+1][i+j] + mat[j][0]*mat[j+k][1]*mat[i+j][1]);
                }
            }
        }

        System.out.print(dp[0][n-1]);
    }
}