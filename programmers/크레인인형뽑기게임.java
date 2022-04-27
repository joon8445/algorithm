import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int length = board.length;
        int m = moves.length;
        Stack<Integer> stack[] = new Stack[length];
        for(int i=0;i<length;i++) stack[i]=new Stack<Integer>();
        Stack<Integer> basket = new Stack<Integer>();
        for(int i=length-1;i>=0;i--){
            for(int j=0;j<length;j++){
                if(board[i][j]>0) stack[j].push(board[i][j]);
            }
        }
        basket.push(0);
        for(int i=0;i<m;i++){
            if(stack[moves[i]-1].empty()) continue;
            int n = stack[moves[i]-1].pop();
            if(basket.peek()==n){
                basket.pop();
                answer+=2;
            }else{
                basket.push(n);
            }
        }
        return answer;
    }
}
