import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void read() throws IOException {
        st = new StringTokenizer(br.readLine());
    }
    static int nextInt(){
        return Integer.parseInt(st.nextToken());
    }
    
    static int n, s, m;
    // static int[] V;
    static boolean[][] dp;
    
    public static void main(String[] args) throws IOException{
        read();
        n = nextInt();
        s = nextInt();
        m = nextInt();

        dp = new boolean[n+1][m+1];
        dp[0][s] = true;

        read();
        for(int i=1; i<=n; i++){
            int v = nextInt();
            for(int j=0; j<=m; j++){
                if(dp[i-1][j]){
                    if(j+v<=m) dp[i][j+v] = true;
                    if(j-v>=0) dp[i][j-v] = true;
                }
            }
        }

        int res = -1;

        for(int i=0; i<=m; i++){
            if(dp[n][i]) res = i;
        }

        System.out.print(res);
        
    }
}