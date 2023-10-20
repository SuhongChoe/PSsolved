class Solution {
    public static int dfs(int i, int[] numbers, int target){
        if(i==numbers.length){
            return target==0 ? 1 : 0;
        }
        return dfs(i+1, numbers, target-numbers[i]) + dfs(i+1, numbers, target+numbers[i]);
    }
    
    public int solution(int[] numbers, int target) {
        return dfs(0,numbers, target);
    }
}