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

    static int n, m;
    static int[] arr;
    static boolean[][] dp;
    
    public static void main(String[] args) throws IOException{
        read();
        n = nextInt();
        arr = new int[n];
        dp = new boolean[n][n];

        read();
        for(int i=0; i<n; i++){
            arr[i] = nextInt();
            dp[i][i] = true;
        }

        for(int i=0; i<n-1; i++){
            if(arr[i]==arr[i+1]){
                dp[i][i+1] = true;
            }
        }

        for(int r=2; r<=n-1;r++){
            for(int i=0; i<n-r; i++){
                if(arr[i]==arr[i+r] && dp[i+1][i+r-1]){
                    dp[i][i+r] = true;
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        
        read();
        m = nextInt();
        while(m-- > 0){
            read();
            if(dp[nextInt()-1][nextInt()-1]) sb.append("1\n");
            else sb.append("0\n");
        }

        System.out.print(sb);
    }
}
