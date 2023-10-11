import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");;

        int res = 0;
        boolean flag = true;

        while (st.hasMoreTokens()){
            int sum = 0;

            StringTokenizer tmp = new StringTokenizer(st.nextToken(), "+");

            while (tmp.hasMoreTokens()) sum += Integer.parseInt(tmp.nextToken());

            if (flag){
                res += sum;
                flag = false;
                continue;
            }
            
            res -= sum;
            
        }

        System.out.print(res);
    }
}