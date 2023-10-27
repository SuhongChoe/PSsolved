import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long res = 0;

        for(int i=0; i<n; i++){
            arr[i] -= b;
            res++;

            if(arr[i]<=0) continue;

            res += arr[i] / c + (arr[i]%c==0 ? 0 : 1);
        }

        System.out.print(res);
    }
}
