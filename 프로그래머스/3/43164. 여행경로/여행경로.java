import java.io.*;
import java.util.*;

class Solution {
    static String[][] tickets;
    static boolean visited[];
    static String res[];
    
    public static void dfs(String from, int cnt, String word){
        if (cnt==tickets.length){
            StringTokenizer st = new StringTokenizer(word);
            
            int i=0;
            while(st.hasMoreTokens()){
                res[i++] = st.nextToken();
            }
            // for(int i=0; i<cnt; i++){
            //     res[i] = st.nextToken();
            // }
        }
        else{
            for(int i=0; i<tickets.length;i++){
                if(!visited[i] && from.equals(tickets[i][0])){
                    String to = tickets[i][1];
                    visited[i] = true;
                    dfs(to, cnt+1, word + " " + to);
                    visited[i] = false;
                }
            }
        }
    }
    
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        Arrays.sort(this.tickets, (s2, s1) -> {
            if (s1[0].equals(s2[0])){
                return s1[1].compareTo(s2[1]);
            }
            return s1[0].compareTo(s2[0]);
        });
        
        visited = new boolean[tickets.length];
        res = new String[tickets.length+1];
        
        dfs("ICN", 0, "ICN");
        
        return res;
    }
}