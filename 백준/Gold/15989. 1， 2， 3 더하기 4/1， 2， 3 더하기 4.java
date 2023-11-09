import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static int[] dp;
    
    public static void main(String[] args) throws IOException{
        int t = Integer.parseInt(br.readLine());
        
        dp = new int[10001];
        dp[0] = 1;

        for(int i=1; i<=3; i++){
            for(int j=i; j<=10000; j++){
                dp[j] += dp[j-i];
            }
        }
        
        StringBuffer sb = new StringBuffer();
        while(t-- > 0) sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        System.out.print(sb);
    }
}