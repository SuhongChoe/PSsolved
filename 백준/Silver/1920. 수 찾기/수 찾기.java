import java.util.*;
import java.io.*;

public class Main {
    static int arr[];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[Integer.parseInt(st.nextToken())];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        StringBuffer sb = new StringBuffer(n*2);

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int target = Integer.parseInt(st.nextToken());
            
            int low = 0;
            int high = arr.length-1;
            boolean flag = false;

            while(low<=high){
                int mid = (low+high)/2;

                if(arr[mid]==target){
                    flag = true;
                    break;
                } else if(arr[mid]>target){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            if (flag) sb.append("1\n");
            else sb.append("0\n");
        }

        System.out.print(sb);
    }
}