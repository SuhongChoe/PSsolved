import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] priorities, int location) {
        ArrayList<int[]> q = new ArrayList<>();
        
        for(int i=0; i<priorities.length; i++){
            q.add(new int[] {i, priorities[i]}); // index, value
        }
        
        Arrays.sort(priorities);
        
        int cnt = 0;
        for(int i=priorities.length-1; i>=0; i--){
            cnt++;
            while (q.get(0)[1] < priorities[i]){
                q.add(q.remove(0));
            }
            if (q.remove(0)[0] == location){
                break;
            }
        }
        
        return cnt;
    }
}