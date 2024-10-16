class Solution {
        public int solution(int m, int n, String[] board) {
            int answer = 0;
            char [][] blocks = new char[m][n];

            for(int i = 0; i < board.length; i++) {
                blocks[i]=board[i].toCharArray();
            }
            while(true){
                int cnt = checkVisit(m,n,blocks);
                if(cnt==0){
                    break;
                }
                answer+=cnt;
            }
            return answer;
        }

        public int checkVisit(int m, int n, char[][]blocks){
            boolean[][] check = new boolean[m][n];
            int count =0;

            for(int i=0;i<m-1;i++){
                for(int j=0;j<n-1;j++){
                    if(blocks[i][j] != '.'&& checkBlock(i,j,blocks)){
                        check[i][j] = check[i][j + 1] = check[i + 1][j] = check[i + 1][j + 1] = true;
                    }
                }
            }

            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(check[i][j]){
                        count+=1;
                        blocks[i][j] = '.';
                    }
                }
            }
            while(dropBlock(m,n,blocks));

            return count;
        }

        public boolean checkBlock(int i, int j,char[][]blocks){
            char c= blocks[i][j];
            return (c==blocks[i][j+1]&&c == blocks[i + 1][j] && c == blocks[i + 1][j + 1]);
        }

        public boolean dropBlock(int m, int n, char[][]blocks){
            boolean isMoved = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m - 1; j++) {
                    if (blocks[j][i] != '.' && blocks[j + 1][i] == '.') {
                        blocks[j + 1][i] = blocks[j][i];
                        blocks[j][i] = '.';
                        isMoved = true;
                    }
                }
            }
            return isMoved;
        }



    }