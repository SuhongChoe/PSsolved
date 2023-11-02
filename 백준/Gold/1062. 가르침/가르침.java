import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void read() throws IOException {
        st = new StringTokenizer(br.readLine());
    }

    static int nextInt() {
        return Integer.parseInt(st.nextToken());
    }

    static int n, k;
    static String[] arr;
    static boolean[] visited = new boolean[26];
    static int res=0;

    static boolean check(String s){
        for(int i=0; i<s.length(); i++){
            if(!visited[s.charAt(i) - 'a']){
                return false;
            }
        }
        return true;
    }

    static void dfs(int idx, int cNum){
        if(cNum==0){
            int cnt = 0;
            for(String s : arr){
                if(check(s)) cnt++;
            }
            res = Math.max(res, cnt);
            return;
        }
        for(int i=idx+1; i<26; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i,cNum-1);
                visited[i] = false;
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        read();
        n = nextInt();
        k = nextInt();
        arr = new String[n];

        for(int i=0; i<n; i++) {
            String tmp = br.readLine();
            arr[i] = tmp.substring(4, tmp.length()-4);
        }

        visited['a'-'a'] = true;
        visited['n'-'a'] = true;
        visited['t'-'a'] = true;
        visited['i'-'a'] = true;
        visited['c'-'a'] = true;

        if(k<5){
            System.out.print(0);
        } else {
            dfs(0, k-5);
            System.out.print(res);
        }
        
    }
}