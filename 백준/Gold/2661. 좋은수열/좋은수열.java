import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static String res="";
    static String[] arr = {"1", "2", "3"};

    static boolean isGood(String num){
        for(int i=1; i <= num.length()/2; i++){
            String str1 = num.substring(num.length()-i, num.length());
            String str2 = num.substring(num.length()-i*2, num.length()-i);
            if(str1.equals(str2)){
                return false;
            }
        }
        return true;
    }

    static void dfs(int cnt, String tmp){
        if(!res.equals("")) return;
        if(cnt==n){
            res = tmp;
            return;
        }
        for(String number : arr){
            String newTmp = tmp+number;
            if(isGood(newTmp))
                dfs(cnt+1, newTmp);
        }
    }
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        dfs(0, "");

        System.out.print(res);
    }
}