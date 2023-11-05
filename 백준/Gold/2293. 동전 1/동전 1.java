import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void read() throws IOException{
        st = new StringTokenizer(br.readLine());
    }
    static int nextInt(){
        return Integer.parseInt(st.nextToken());
    }

    static int n, k;

    public static void main(String[] args) throws IOException{
        read();
        n = nextInt();
        k = nextInt();
        int[] dp = new int[k+1];
        dp[0] = 1;

        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());

            for(int j=num; j<=k; j++){
                dp[j] += dp[j-num];
            }
        }
        System.out.print(dp[k]);
    }
}
