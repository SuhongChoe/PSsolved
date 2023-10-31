import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void read() throws IOException {
        st = new StringTokenizer(br.readLine());
    }

    static int nextInt(){
        return Integer.parseInt(st.nextToken());
    }

    static int[] arr = new int[10];

    public static void main(String[] args) throws IOException{
        read();
        int t = nextInt();

        StringBuffer sb = new StringBuffer();

        while(t-- > 0){
            read();
            for(int i=0; i<10; i++) arr[i] = nextInt();
            Arrays.sort(arr);

            sb.append(arr[10-3]).append("\n");
        }

        System.out.print(sb);
    }
}
