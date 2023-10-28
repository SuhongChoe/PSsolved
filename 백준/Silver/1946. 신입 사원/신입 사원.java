import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n+1];

            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }

            /*
            1 2 3 4 5 6 7
            4 5 6 2 7 1 3
             */

            int tmp = arr[1];
            int cnt = 0;
            for(int i=2; i<=n; i++){
                if(tmp<arr[i]){
                    cnt++;
                } else {
                    tmp = arr[i];
                }
            }

            sb.append(n-cnt).append("\n");
        }

        System.out.print(sb);
    }
}