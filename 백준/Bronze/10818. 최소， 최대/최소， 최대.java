import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int min = 1000001;
        int max = -1000001;

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()){
            n = Integer.parseInt(st.nextToken());
            if (min > n) min = n;
            if (max < n) max = n;
        }

        System.out.print(min + " " + max);
        
    }
}
