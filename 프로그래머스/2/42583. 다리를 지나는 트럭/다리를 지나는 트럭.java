import java.io.*;
import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayList<Integer> trucks = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        
        int time = 0;
        int cur_weight = 0;
        
        for(int truck : truck_weights) trucks.add(truck);
        for(int i=0; i<bridge_length; i++) arr.add(0);
        
        while(!trucks.isEmpty()){
            time++;
            if(cur_weight+trucks.get(0)<=weight){
                arr.add(trucks.get(0));
                cur_weight += trucks.remove(0) - arr.remove(0);
            } else {
                cur_weight -= arr.remove(0);
                if(cur_weight+trucks.get(0)<=weight){
                    arr.add(trucks.get(0));
                    cur_weight += trucks.remove(0);
                } else {
                    arr.add(0);
                }
            }
        }
        
        return time+bridge_length;
    }
}