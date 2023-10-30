import java.util.*;
import java.io.*;

public class Main {

    static int n;

    static String[] nums = {"1", "2", "3"};

    public static boolean isGood(String num){
        int mid = num.length()/2;

        for(int i=1;i<=mid; i++) {
            String right = num.substring(num.length() - i, num.length());
            String left = num.substring(num.length() - i * 2, num.length() - i);

            if(left.equals(right)) return false;
        }
        return true;
    }

    static StringBuffer sb = new StringBuffer();

    public static void dfs(String tmp){
        if(sb.length()>0) return;
        if(tmp.length()==n){
            sb.append(tmp);
            return;
        }
        for(String num : nums){
            String new_tmp = tmp + num;
            if(isGood(new_tmp)){
                dfs(new_tmp);
            }
        }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        dfs("");

        System.out.print(sb);

    }
}
