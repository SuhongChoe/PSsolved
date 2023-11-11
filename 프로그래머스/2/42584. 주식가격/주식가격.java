import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] prices) {
        Deque<int[]> dq = new LinkedList<>();
        ArrayList<int[]> ps = new ArrayList<>();
        
        for(int i=0; i<prices.length; i++){
            ps.add(new int[] {i, prices[i]}); // idx, value
        }
        
        
        int res[] = new int[ps.size()];
        
        for(int i=0;i<ps.size(); i++){
            while(!dq.isEmpty() && dq.peekLast()[1] > ps.get(i)[1]){
                int idx = dq.pollLast()[0];
                res[idx] = i-idx;
            }
            dq.addLast(ps.get(i));
        }
        
        while(!dq.isEmpty()){
            int idx = dq.pollLast()[0];
            res[idx] = ps.size() - 1 - idx;
        }
        
        return res;
    }
}
