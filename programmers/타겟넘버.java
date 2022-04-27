
class Solution {
    static int answer=0;
    public int solution(int[] numbers, int target) {
        solve(numbers,target,0,0);
        return answer;
    }
    static void solve(int[] numbers,int target, int depth, int sum){
        if(depth==numbers.length){
            if(sum==target) answer++;
            return;
        }
        solve(numbers,target,depth+1,sum+numbers[depth]);
        solve(numbers,target,depth+1,sum-numbers[depth]);
        
}
}

