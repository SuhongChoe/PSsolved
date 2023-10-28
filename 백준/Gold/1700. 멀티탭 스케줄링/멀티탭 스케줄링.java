import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void next() throws IOException {
        st = new StringTokenizer(br.readLine());
    }

    static int nextInt(){
        return Integer.parseInt(st.nextToken());
    }

    public static int findElec(int i){
        int target = 0;
        boolean[] visited = new boolean[k+1];

        for(int j=i+1; j<k; j++){
            if(using.contains(arr[j]) && !visited[arr[j]]){
                visited[arr[j]] = true;
                target = arr[j];
            }
        }
        for(int elec : using){
            if(nums[elec]==0){
                target = elec;
            }
        }

        return target;
    }

    static int[] nums;
    static int[] arr;
    static int n, k;
    static HashSet<Integer> using = new HashSet<>();


    public static void main(String[] args) throws IOException{
        next();
        n = nextInt();
        k = nextInt();

        arr = new int[k];
        nums = new int[k+1];

        next();
        for(int i=0; i<k; i++){
            arr[i] = nextInt();
            nums[arr[i]]++;
        }

        int cnt=0;

        for(int i=0; i<k; i++){
            nums[arr[i]]--;
            if(using.size()==n && !using.contains(arr[i])){
                cnt++;
                using.remove(findElec(i));
            }
            using.add(arr[i]);
        }

        System.out.print(cnt);

    }
}