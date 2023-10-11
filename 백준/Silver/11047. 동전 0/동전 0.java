import java.util.*;
import java.io.*;

public class Main {
    static int n, m, coins[], count=0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        coins = new int[n];

        for(int i=0; i<n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coins);

        while(m>0){
            int tmp = m / coins[n-1];
            count += tmp;
            m = m % coins[n-1];
            n--;
        }

        System.out.print(count);
        
    }
}