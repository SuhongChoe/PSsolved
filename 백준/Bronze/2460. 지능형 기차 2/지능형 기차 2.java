import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void read() throws IOException {
        st = new StringTokenizer(br.readLine());
    }
    public static int nextInt() {
        return Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws IOException{
        int res = 0;
        int cur = 0;

        for(int i=0; i<10; i++){
            read();
            int out = nextInt();
            int in = nextInt();

            cur += in - out;

            if(res<cur) res = cur;
        }

        System.out.print(res);
    }
}
