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
    static int[] scv;
    static int[][][] dp = new int[61][61][61];

    static int dfs(int r1, int r2, int r3){        
        if(r1 < 0) r1 = 0;
        if(r2 < 0) r2 = 0;
        if(r3 < 0) r3 = 0;

        if(dp[r1][r2][r3]<Integer.MAX_VALUE) return dp[r1][r2][r3];

        dp[r1][r2][r3] = Math.min(dp[r1][r2][r3], dfs(r1-9, r2-3, r3-1)+1);
        dp[r1][r2][r3] = Math.min(dp[r1][r2][r3], dfs(r1-9, r2-1, r3-3)+1);
        dp[r1][r2][r3] = Math.min(dp[r1][r2][r3], dfs(r1-3, r2-9, r3-1)+1);
        dp[r1][r2][r3] = Math.min(dp[r1][r2][r3], dfs(r1-3, r2-1, r3-9)+1);
        dp[r1][r2][r3] = Math.min(dp[r1][r2][r3], dfs(r1-1, r2-3, r3-9)+1);
        dp[r1][r2][r3] = Math.min(dp[r1][r2][r3], dfs(r1-1, r2-9, r3-3)+1);

        return dp[r1][r2][r3];
    }
    
    public static void main(String[] args) throws IOException{
        read();
        n = nextInt();
        scv = new int[3];
        for(int i=0; i<=60; i++){
            for(int j=0; j<=60; j++){
                for(int k=0; k<=60; k++){
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        read();
        for(int i=0; i<n; i++) scv[i] = nextInt();
        
        dp[0][0][0] = 0;
        
        System.out.print(dfs(scv[0], scv[1], scv[2]));
    }
}