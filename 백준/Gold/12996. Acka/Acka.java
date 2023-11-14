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

    static long[][][][] dp;

    static long dfs(int s, int a, int b, int c){
        if(s<=0){
            if(a==0 && b==0 && c==0) return 1;
            else return 0;
        }

        if(a < 0 || b < 0 || c < 0) return 0;

        if(dp[s][a][b][c] != -1) return dp[s][a][b][c];

        long sum = 0;
        sum += dfs(s-1, a-1, b, c);
        sum += dfs(s-1, a, b-1, c);
        sum += dfs(s-1, a, b, c-1);
        sum += dfs(s-1, a-1, b-1, c);
        sum += dfs(s-1, a-1, b, c-1);
        sum += dfs(s-1, a, b-1, c-1);
        sum += dfs(s-1, a-1, b-1, c-1);

        sum %= 1000000007;

        dp[s][a][b][c] = sum;

        return sum;
    }
    
    public static void main(String[] args) throws IOException{
        read();
        int s = nextInt();
        int a = nextInt();
        int b = nextInt();
        int c = nextInt();

        dp = new long[s+1][a+1][b+1][c+1];

        for(int i=0; i<=s; i++){
            for(int j=0; j<=a; j++){
                for(int k=0; k<=b; k++){
                    for(int l=0; l<=c; l++){
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }

        System.out.print(dfs(s, a, b, c));
    }
}