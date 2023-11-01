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
    static long nextLong(){
        return Long.parseLong(st.nextToken());
    }

    static int n;
    static long[] arr;
    static int[] op = new int[4];
    static long min=1000000001l;
    static long max=-1000000001l;

    static long cal(long a, long b, int i){
        if(i==0) return a+b;
        else if(i==1) return a-b;
        else if(i==2) return a*b;
        else return a/b;
    }
    
    static void dfs(int idx, long num){
        if(idx==n-1){
            if(min>num) min = num;
            if(max<num) max = num;
            return;
        }
        for(int i=0; i<4; i++){
            if(op[i]>0){
                op[i]--;
                dfs(idx+1, cal(num, arr[idx+1], i));
                op[i]++;
            }
        }
    }
    
    
    public static void main(String[] args) throws IOException{
        read();
        n = nextInt();
        arr = new long[n];
        
        read();
        for(int i=0; i<n; i++) arr[i] = nextLong();

        // + - * /
        read();
        for(int i=0; i<4; i++) op[i] = nextInt();
        dfs(0, arr[0]);

        System.out.println(max);
        System.out.print(min);
    }
}