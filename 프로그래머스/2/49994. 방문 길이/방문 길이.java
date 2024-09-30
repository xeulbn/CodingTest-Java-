import java.util.HashSet;

class Solution {

    public int solution(String dirs) {
        int answer = 0;
        int map [] [] = new int [11][11];
        HashSet<String> visited = new HashSet<>();

        int currentX=0, currentY=0;

        for(int i=0;i<dirs.length();i++){
            int nextX= currentX;
            int nextY= currentY;
            String move="";

            char where= dirs.charAt(i);
            if(where=='U'){
                nextY++;
                move += currentX + "," + currentY + "->" + nextX +  nextY;
            }else if(where=='D'){
                nextY--;
                move += nextX + "," + nextY + "->" + currentX + currentY ;
            }else if(where=='L'){
                nextX--;
                move += nextX + "," + nextY + "->" + currentX + currentY;
            }else if(where=='R'){
                nextX++;
                move += currentX + "," + currentY + "->" + nextX + nextY;
            }

            if(nextX<-5||nextY<-5||nextY>5||nextX>5){
                continue;
            }
            visited.add(move);

            currentX=nextX;
            currentY=nextY;
        }

        answer= visited.size();

        return answer;
    }
}