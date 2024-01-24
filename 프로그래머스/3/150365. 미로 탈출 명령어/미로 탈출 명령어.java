class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        int down=0, up=0;
        int left=0, right=0;
        int distance;
        distance= Math.abs(r-x)+Math.abs(c-y);
        if(distance>k){
            return "impossible";
        }
        if((k-distance)%2!=0){
            return "impossible";
        }

        down=Math.max(r-x,0);
        left=Math.max(y-c,0);
        right=Math.max(c-y,0);
        up=Math.max(x-r,0);


        int pair;
        pair=(k-distance)/2;

        for(int i=0;i<k;i++){
            if((down>0||pair!=0)&&x<n){
                answer=answer+"d";
                if(down>0){
                    down-=1;
                }else{
                    pair-=1;
                    up+=1;
                }
                x+=1;
            } else if ((left>0||pair!=0)&&y>1) {
                answer+="l";
                if(left>0){
                    left-=1;
                }else{
                    pair-=1;
                    right+=1;
                }
                y-=1;
            } else if((right>0||pair!=0)&&y<m){
                answer+="r";
                if(right>0){
                    right-=1;
                }else{
                    pair-=1;
                    left+=1;
                }
                y+=1;
            } else if((up>0||pair!=0)&&x>1){
                answer+="u";
                if(up>0){
                    up-=1;
                }else{
                    pair-=1;
                    down+=1;
                }
                x-=1;
            }
        }
        return answer;
    }
}