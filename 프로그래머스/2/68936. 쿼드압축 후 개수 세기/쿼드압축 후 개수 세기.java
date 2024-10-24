class Solution {
        int[] answer;

        public int[] solution(int[][] arr) {
            answer= new int[2];
            dfs(arr.length,0,0,arr);

            return answer;
        }

        public void dfs(int n, int x, int y, int[][] arr){
            if(n==1){
                answer[arr[x][y]] ++;
                return;
            }
            if(isEqual(n,x,y,arr)){
                return;
            }

            dfs(n/2,x,y,arr);
            dfs(n/2,x+n/2,y,arr);
            dfs(n/2,x,y+n/2,arr);
            dfs(n/2,x+n/2,y+n/2,arr);
        }

        public boolean isEqual(int n, int x, int y, int[][] arr){
            int temp = arr[x][y];
            for(int i=x;i<x+n;i++){
                for(int j=y;j<y+n;j++){
                    if(temp!= arr[i][j]){
                        return false;
                    }
                }
            }

            answer[temp]++;
            return true;
        }
    }