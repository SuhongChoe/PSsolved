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

    static int n;
    static int[][] graph;
    static long[][] dp;
    
    public static void main(String[] args) throws IOException{
        read();
        n = nextInt();
        graph = new int[n][n];
        dp = new long[n][n];

        for(int i=0; i<n; i++){
            read();
            for(int j=0; j<n; j++){
                graph[i][j] = nextInt();
            }
        }

        dp[0][0] = 1;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<i; k++){ // 열
                    if(graph[k][j]+k==i) dp[i][j] += dp[k][j];
                }
                for(int k=0; k<j; k++){
                    if(graph[i][k]+k==j) dp[i][j] += dp[i][k];
                }
            }
        }
        System.out.print(dp[n-1][n-1]);
    }
}