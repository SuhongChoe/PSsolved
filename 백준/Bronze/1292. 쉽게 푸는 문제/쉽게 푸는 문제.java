import java.util.*;
import java.io.*;

public class Main {
    static int[] arr = new int[45*46+1];
    static int a, b;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        for(int n=1; n<=45; n++){
            int start = (n-1)*n/2+1;
            for(int i=0; i<n; i++){
                arr[start+i] = n;
            }
        }

        int sum = 0;
        
        for(int i=a; i<=b; i++) sum+=arr[i];

        System.out.print(sum);

    }
}