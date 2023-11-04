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

    static int n, s;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        read();
        n = nextInt();
        s = nextInt();
        arr = new int[n];

        int sum = 0;
        int res = 100000;

        read();
        for(int i=0; i<n; i++) arr[i] = nextInt();

        int start = 0;
        for(int end=0; end<n; end++){
            sum += arr[end];
            while(start<=end && sum>=s){
                sum -= arr[start];
                res = Math.min(end - start + 1, res);
                start++;
            }
        }

//        while(start<n && sum-arr[start]>=s) {
//            sum -= arr[start];
//            res = Math.min(n - start, res);
//            start++;
//        }

        if(res==100000) res = 0;

        System.out.print(res);
    }
}
