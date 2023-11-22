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

    static int n, k;
    static boolean[][][][] dp;
    static char[] s;

    static boolean dfs(int i, int a, int b, int cnt){
        if(i==n){
            return (k==cnt) ? true : false;
        }

        if(dp[i][a][b][cnt]){
            return false;
        }

        dp[i][a][b][cnt] = true;

        // a 선택
        s[i] = 'A';
        dp[i][a][b][cnt] = true;
        if(dfs(i+1, a+1, b, cnt)) return true;
        
        // b 선택
        s[i] = 'B';
        dp[i][a][b][cnt] = true;
        if(dfs(i+1, a, b+1, cnt+a)) return true;
        
        // c 선택
        s[i] = 'C';
        dp[i][a][b][cnt] = true;
        if(dfs(i+1, a, b, cnt+a+b)) return true;

        return false;
    }
    
    public static void main(String[] args) throws IOException{
        read();
        n = nextInt();
        k = nextInt();
        s = new char[n];
        dp = new boolean[n+1][n+1][n+1][n*(n-1)/2+1];

        String res = (dfs(0, 0, 0, 0)) ? new String(s) : "-1";

        System.out.print(res);
    }
}