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

    public static class Schedule {
        int t=0;
        int p=0;
        Schedule(int t, int p){
            this.t = t;
            this.p = p;
        }
    }

    static int n;
    static int[] T, P, dp;
    
    public static void main(String[] args) throws IOException{
        read();
        n = nextInt();
        T = new int[n+2];
        P = new int[n+2];
        dp = new int[n+2];

        for(int i=1; i<=n; i++){
            read();
            T[i] = nextInt();
            P[i] = nextInt();
        }

        for(int i=n;i>=1; i--){
            dp[i] = dp[i+1];
            
            if(T[i]+i <= n+1) { 
                dp[i] = Math.max(dp[T[i] + i] + P[i], dp[i]);
            }
        }
        
        System.out.print(dp[1]);

    }
}