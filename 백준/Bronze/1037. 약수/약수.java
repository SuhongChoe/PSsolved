import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int min = 1000001;
        int max = 1;

        for(int i=0; i<n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (min > tmp) min = tmp;
            if (max < tmp) max = tmp;
        }

        System.out.print(min*max);

    }
}