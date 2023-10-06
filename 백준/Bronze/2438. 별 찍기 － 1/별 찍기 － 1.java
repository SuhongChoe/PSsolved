import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String[] res = new String[100];

        for(int i=0; i<n; i++){
            res[i] = "*".repeat(i+1);
        }

        for(int i=0; i<n; i++){
            System.out.println(res[i]);
        }
    }
}