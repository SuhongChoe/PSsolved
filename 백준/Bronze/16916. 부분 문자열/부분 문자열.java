import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static char[] s, p;
    static int[] kmp_table;

    public static int kmp(){
        kmp_table = new int[p.length];

        int j=0;
        for(int i=1; i<p.length; i++){
            while(j>0 && p[i]!=p[j]) j = kmp_table[j-1];
            if(p[i]==p[j]) kmp_table[i] = ++j;
        }
        
        j = 0;
        for(int i=0;i<s.length;i++){
            while(j>0 && s[i]!=p[j]) j = kmp_table[j-1];
            if(s[i]==p[j]) j++;
            if(j==p.length) return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException{
        s = br.readLine().toCharArray();
        p = br.readLine().toCharArray();

        System.out.print(kmp());
    }
}
