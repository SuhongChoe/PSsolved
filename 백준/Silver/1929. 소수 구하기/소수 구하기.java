import java.util.*;
import java.io.*;

public class Main {
    public static void eratosthenes(int start, int end){
        boolean visited[] = new boolean[end+1];

        StringBuffer sb = new StringBuffer();

        for(int i=2; i<=end; i++){
            if (!visited[i]){
                if (i>=start) sb.append(i).append('\n');
                for(int j=i; j<=end; j += i){
                    visited[j] = true;
                }
            }
        }

        System.out.print(sb);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        eratosthenes(s, e);
    }
}