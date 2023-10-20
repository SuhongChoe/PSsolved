class Solution {
    static int res = 0;
    
    public static void dfs(int i, int[] numbers, int target){
        if(i==numbers.length){
            if(target==0) res++;
            return;
        }
        dfs(i+1, numbers, target-numbers[i]);
        dfs(i+1, numbers, target+numbers[i]);
    }
    
    public int solution(int[] numbers, int target) {
        
        dfs(0,numbers, target);
        
        return res;
    }
}