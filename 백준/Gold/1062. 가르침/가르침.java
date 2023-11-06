import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void read() throws IOException{
        st = new StringTokenizer(br.readLine());
    }
    static int nextInt() {
        return Integer.parseInt(st.nextToken());
    }

    static int n, k, res;
    static String[] arr;
    static boolean[] visited = new boolean[26];

    static boolean canLearn(String tmp){
        for(int i=0; i<tmp.length(); i++){
            if(!visited[tmp.charAt(i)-'a']){
                return false;
            }
        }
        return true;
    }

    static void bfs(int idx, int cnt){
        if(cnt==k-5){
            int com_cnt = 0;
            for(String str : arr) if(canLearn(str)) com_cnt++;

            res = Math.max(res, com_cnt);
            return;
        }
        for(int i=idx; i<26; i++){
            if(!visited[i]){
                visited[i] = true;
                bfs(i+1, cnt+1);
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
        visited['c'-'a'] = true;
        visited['i'-'a'] = true;

        res = 0;

        if(k>=5) bfs(0, 0);
        
        System.out.print(res);
    }
}