import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void next() throws IOException{
        st = new StringTokenizer(br.readLine());
    }
    static int nextInt(){
        return Integer.parseInt(st.nextToken());
    }

    static int n, s;
    static int[] arr;
    static int cnt=0;

    public static void dfs(int idx, int sum){
        if(idx==n) return;
        
        sum -= arr[idx];

        if(sum==0) cnt++;

        dfs(idx+1, sum+arr[idx]);
        dfs(idx+1, sum);
    }

    public static void main(String[] args) throws IOException {
        next();
        n = nextInt();
        s = nextInt();

        arr = new int[n];

        next();
        for(int i=0; i<n; i++) arr[i] = nextInt();
        Arrays.sort(arr);

        dfs(0, s);

        System.out.print(cnt);
    }
}
