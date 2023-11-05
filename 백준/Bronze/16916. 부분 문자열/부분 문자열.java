import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static String s, p;
    static int[] kmp_table;

    public static void kmp(String p){
        kmp_table = new int[p.length()];

        int i=0;
        for(int j=1; j<p.length(); j++){
            while(i>0 && p.charAt(i)!=p.charAt(j)){
                i = kmp_table[i-1];
            }
            if(p.charAt(i)==p.charAt(j)){
                i++;
                kmp_table[j] = i;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        s = br.readLine();
        p = br.readLine();

        kmp(p);

        int res=0;

        int j=0;
        for(int i=0;i<s.length();i++){
            while(j>0 && s.charAt(i)!=p.charAt(j)){
                j = kmp_table[j-1];
            }
            if(s.charAt(i)==p.charAt(j)){
                j++;
                if(j==p.length()){
                    res = 1;
                    break;
                }

            }
        }

        System.out.print(res);
    }
}
