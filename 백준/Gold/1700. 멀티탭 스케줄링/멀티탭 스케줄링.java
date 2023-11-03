import java.util.*;
import java.io.*;

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
    static int[] arr, num;
    static HashSet<Integer> using = new HashSet<>();

    public static int findElec(int i){
        boolean[] visited = new boolean[k+1];
        int target = 0;
        
        for(int j=i+1; j<k; j++){
            if(using.contains(arr[j]) && !visited[arr[j]]){
                visited[arr[j]] = true;
                target = arr[j];
            }
        }

        for(int elec : using){
            if(num[elec]==0){
                target = elec;
            }
        }
        
        return target;
    }

    public static void main(String[] args) throws IOException{
        read();
        n = nextInt();
        k = nextInt();
        arr = new int[k];
        num = new int[k+1];

        read();
        for(int i=0; i<k; i++) {
            arr[i] = nextInt();
            num[arr[i]]++;
        }

        int res = 0;

        for(int i=0; i<k; i++){
            num[arr[i]]--;
            if(using.size()==n && !using.contains(arr[i])){
                res++;
                using.remove(findElec(i));
            }
            using.add(arr[i]);
        }
        System.out.print(res);
    }
}