import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int sum=0;
        int max=0;
        int tmp;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            tmp = Integer.parseInt(st.nextToken());
            sum+=tmp;
            if(max<tmp) max=tmp;
        }
        
        System.out.print((sum-max)+max*(n-1));
    }
}
