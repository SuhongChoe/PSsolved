import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int numlength = Integer.parseInt(st.nextToken());
        int res = 0;

        st = new StringTokenizer(br.readLine());
        String num = st.nextToken();
        for(int i=0; i < num.length(); i++){
            res += Integer.parseInt(num.substring(i, i+1));
        }

        System.out.println(res);
    }
}
