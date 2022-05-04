import java.util.*;

class Solution {
    static char[] nums;
    static HashSet<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        nums = numbers.toCharArray();
        choose(nums, new boolean[nums.length], new char[nums.length],0);
        int answer = set.size();
        return answer;
    }
    void choose(char[] numbers, boolean[] isSelected, char[] selected,int cnt){
        toInteger(selected,cnt);
        for(int i=0;i<numbers.length;i++){
            if(isSelected[i]) continue;
            isSelected[i]=true;
            selected[cnt]=numbers[i];
            choose(numbers,isSelected,selected,cnt+1);
            isSelected[i]=false;
        }
    }
    void toInteger(char[] selected, int cnt){
        int result=0;
        for(int i=0;i<cnt;i++){
            result*=10;
            result+=(int)(selected[i]-'0');
        }
        if(check(result)){
            set.add(result);
        }
    }
    boolean check(int result){
        if(result<=1) return false;
        for (int i = 2; i<=(int)Math.sqrt(result); i++) {
            if (result % i == 0) {
                return false;
            }
        }
	    return true;
    }
}
