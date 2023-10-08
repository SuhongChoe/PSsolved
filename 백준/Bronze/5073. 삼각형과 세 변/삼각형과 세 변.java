import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String res = "";

        while(true){
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[3];
            for(int i=0; i<3; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            if (arr[2]==0) break;

            if (arr[2]>=arr[0]+arr[1]) res += "Invalid\n";
            else if (arr[0]==arr[2]) res += "Equilateral\n";
            else if (arr[0]==arr[1] || arr[1]==arr[2]) res += "Isosceles\n";
            else res += "Scalene\n";
        }

        System.out.print(res);
    }
}
