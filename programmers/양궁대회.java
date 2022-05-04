class Solution {
    static int max = -1;
    static int[] answer;
    public int[] solution(int n, int[] info) {
        answer = new int[11];
        dfs(0,n,0,info,new int[11]);
        if(max<=0) answer=new int[] {-1};
        return answer;
    }
    void dfs(int cnt,int n,int start, int[] apeach, int[] ryan){
        if(cnt==n){
            int ryanScore = score(apeach,ryan);
            if(ryanScore<max) return;
            if(ryanScore>max){
                max=ryanScore;
                answer=ryan.clone();
            }else if(ryanScore==max){
                for(int i=10;i>0;i--){
                    if(ryan[i]==answer[i]) continue;
                    if(ryan[i]>answer[i]){
                        answer=ryan.clone();
                        return;
                    }else{
                        return;
                    }
                }
            }
            return;
        }
        for(int i=start;i<11;i++){
            ryan[i]++;
            dfs(cnt+1,n,i,apeach,ryan);
            ryan[i]--;
        }
    }
    
    
    int score(int[] apeach, int[] ryan){
        int a=0,r=0;
        for(int i=0;i<11;i++){
            if(apeach[i]==0&&ryan[i]==0) continue;
            if(apeach[i]<ryan[i]) r+=10-i;
            else a+=10-i;
        }
        return r-a;
    }
}
