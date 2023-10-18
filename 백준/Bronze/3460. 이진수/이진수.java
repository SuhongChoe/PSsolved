import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            StringBuffer sb = new StringBuffer();
            
            int cnt = 0;
            while (n>0){
                sb.append((n&1)==1 ? 1 : 0);
                n >>= 1;
                cnt+=1;
            }

            for(int i=0; i<cnt; i++){
                if (sb.charAt(i)=='1') System.out.print(i + " ");
            }
            System.out.println();
            
        }
    }
}