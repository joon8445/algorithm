import java.util.*;

class Solution {
    public int solution(String s) {
        int length = s.length();
        int answer = length;
        int size = length/2;
        for(int i=1;i<=size;i++){
            answer = Math.min(solve(s,i),answer);
        }
        return answer;
    }
    int solve(String s, int size){  //size:자르는 단위
        int length = s.length();
        int zip = length;
        int last = length-size;
        for(int start=0;start<=last;start+=size){
            int index = start+size;
            String str = s.substring(start,size+start);
            int cnt=1;  //반복된 횟수
            boolean flag = false;
            while(index+size<=length&&str.equals(s.substring(index,index+size))){
                flag = true;
                cnt++;
                zip-=size;
                start=index;
                index+=size;
            } 
            while(flag) {
                zip+=1;
                cnt/=10;
                if(cnt<1) flag=false;
            }
        }
        return zip;
    }
}
