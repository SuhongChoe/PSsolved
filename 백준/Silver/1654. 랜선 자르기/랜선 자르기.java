import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int arr[] = new int[k];
        long low = 1;
        long high = Integer.MAX_VALUE;

        for(int i=0; i<k; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        long res=0;

        while(low<=high){
            long mid = (low+high)/2;
            long sum=0;

            for(int len : arr) sum += len/mid;

            /*
            sum이 커지기 위해선? -> 길이를 줄여야함 high를 낮춰야함
             */

            if (sum>=n) {
                low = mid + 1;
                res = mid;
            } else {
                high = mid - 1;
            }

        }
        System.out.print(res);
    }
}
