class Solution {
        public int[] solution(int n) {

            int x=-1;
            int y=0;
            int num=1;

            int[][]tri=new int[n][n];
            int[] answer = new int[n*(n+1)/2];

            for(int i=0;i<n;i++){
                for(int j=i;j<n;j++){
                    if(i%3==0){
                        x++;
                    }else if(i%3==1){
                        y++;
                    }else if(i%3==2){
                        x--;
                        y--;
                    }
                    tri[x][y]=num++;
                }
            }

            int index=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(tri[i][j]==0)
                        break;
                    answer[index++]=tri[i][j];
                }
            }
            return answer;
        }
    }