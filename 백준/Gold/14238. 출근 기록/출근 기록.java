import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static char[] S;
    static boolean[][][][][] dp;
    static int A=0, B=0, C=0;
    static char[] res = new char[51];

    /*
    bb
    cc
    c c
    */
    static boolean dfs(int a, int b, int c, int pp, int p){
        if(a==A && b==B && c==C) return true;

        if(dp[a][b][c][pp][p]) return false;
        dp[a][b][c][pp][p] = true;

        if(a+1 <= A){
            res[a+b+c] = 'A';
            if(dfs(a+1, b, c, p, 0)) return true;
        }

        if(b+1 <= B){
            res[a+b+c] = 'B';
            if(p !=1 && dfs(a, b+1, c, p, 1)) return true;
        }

        if(c+1 <= C){
            res[a+b+c] = 'C';
            if(p != 2 && pp != 2 && dfs(a, b, c+1, p, 2)) return true;
        }

        return false;
    }
    
    public static void main(String[] args) throws IOException{
        for(char alph : br.readLine().toCharArray()){
            if(alph=='A') A++;
            else if(alph=='B') B++;
            else C++;
        }

        dp = new boolean[A+1][B+1][C+1][3][3];

        String answer = (dfs(0,0,0,0,0)) ? new String(res) : "-1";

        System.out.print(answer.trim());
    }
}