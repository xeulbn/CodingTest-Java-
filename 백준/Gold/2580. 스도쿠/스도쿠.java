import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int[][] sdoku;
    public static List<Node> empties;
    public static boolean solved = false;

    public static class Node{
        int x;
        int y;
        
        public Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        sdoku=new int[9][9];
        empties=new ArrayList<>();
        for(int i=0;i<9;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++){
                sdoku[i][j]=Integer.parseInt(st.nextToken());
                if(sdoku[i][j]==0){
                    empties.add(new Node(i,j));
                }
            }
        }

        solveSdoku(0);

        StringBuilder sb= new StringBuilder();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                sb.append(sdoku[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void solveSdoku(int depth){
        if(solved){
            return;
        }

        if(depth==empties.size()){
            solved=true;
            return;
        }

        Node pos = empties.get(depth);
        int row = pos.x;
        int col = pos.y;

        for(int i=1;i<=9;i++){
            if(isValid(row,col,i)){
                sdoku[row][col]=i;
                solveSdoku(depth+1);
                if(solved){
                    return;
                }
                sdoku[row][col]=0;
            }
        }
    }

    public static boolean isValid(int row, int col, int num){
        for(int x=0;x<9;x++){
            if(sdoku[row][x]==num){
                return false;
            }
        }

        for(int x=0;x<9;x++){
            if(sdoku[x][col]==num){
                return false;
            }
        }

        int sr= (row/3)*3;
        int sc = (col/3)*3;

        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(sdoku[i][j]==num){
                    return false;
                }
            }
        }

        return true;
    }
}