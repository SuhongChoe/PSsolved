import java.util.*;
import java.io.*;

class Solution {
    static String[][] tickets;
    static boolean[] visited;
    static Deque<String> res = new LinkedList<>();
    
    public static boolean dfs(String from){
        
        res.addLast(from);
        
        if (res.size()==tickets.length+1){
            return true;
        }
        
        for(int i=0; i<tickets.length; i++){
            if (tickets[i][0].equals(from) && !visited[i]){
                visited[i] = true;
                if (dfs(tickets[i][1])){
                    return true;
                }
                visited[i] = false;
            }
        }
        
        res.pollLast();
        
        return false;
    }
    
    
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        visited = new boolean[tickets.length];
        
        Arrays.sort(this.tickets, (s1, s2) -> {
            if (s1[0].equals(s2[0])){
                return s1[1].compareTo(s2[1]);
            }
            return s1[0].compareTo(s2[0]);
        });
        
        dfs("ICN");
        
        String[] result = new String[tickets.length+1];
        
        for(int i=0; i<tickets.length+1;i++){
            result[i] = res.pollFirst();
        }
        
        return result;
    }
}
