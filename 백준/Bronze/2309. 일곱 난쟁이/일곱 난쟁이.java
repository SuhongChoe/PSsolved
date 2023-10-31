import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int readInt() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    public static void main(String[] args) throws IOException{
        int[] arr = new int[9];
        int sum = 0;
        for(int i=0; i<9; i++) {
            arr[i] = readInt();
            sum += arr[i];
        }

        Arrays.sort(arr);

        StringBuffer sb = new StringBuffer();

        int a=-1;
        int b=-1;

        for(int i=0; i<8; i++){
            for(int j=i+1; j<9; j++){
                if(sum-arr[i]-arr[j]==100){
                    a = i;
                    b = j;
                }
            }
        }
        for(int i=0; i<9; i++){
            if(!(i==a || i==b)) sb.append(arr[i]).append("\n");
        }

        System.out.print(sb);

    }
}
