import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int res = Integer.MAX_VALUE;
    static int a, b;

    static void dfs(long tmp, int cnt){
        if(tmp>b) return;
        if(tmp==b){
            res = Math.min(res, cnt+1);
            return;
        }
        
        dfs(tmp*2, cnt+1);
        dfs(tmp*10+1, cnt+1);
    }
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        dfs(a, 0);

        if(res==Integer.MAX_VALUE) res = -1;

        System.out.print(res);
    }
}