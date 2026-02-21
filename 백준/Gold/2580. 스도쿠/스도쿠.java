import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static int n;
    public static int[][] sdoku;
    public static ArrayList<int[]> empty = new ArrayList<>();
    public static boolean solved=false;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        sdoku=new int[9][9];

        for(int i=0;i<9;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++){
                sdoku[i][j]=Integer.parseInt(st.nextToken());
                if(sdoku[i][j]==0){
                    empty.add(new int[]{i,j});
                }
            }
        }

        dfs(0);

        StringBuilder sb= new StringBuilder();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                sb.append(sdoku[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
    
    public static void dfs(int index){
        if(solved){
            return;
        }

        if(index==empty.size()){
            solved=true;
            return;
        }

        int[] pos = empty.get(index);
        int row = pos[0];
        int col = pos[1];

        for(int num=1;num<=9;num++){
            if(isValid(row,col,num)){
                sdoku[row][col]=num;
                dfs(index+1);
                if(solved)
                    return;
                sdoku[row][col]=0;
            }
        }
    }

    public static boolean isValid(int row,int col, int num){
        //row 체크
        for(int x=0;x<9;x++){
            if(sdoku[row][x]==num){
                return false;
            }
        }

        //col 체크
        for(int y=0;y<9;y++){
            if(sdoku[y][col]==num){
                return false;
            }
        }

        // 9*9 체크
        int smallRow = (row/3)*3;
        int smallCol = (col/3)*3;

        for(int i=smallRow;i<smallRow+3;i++){
            for(int j=smallCol;j<smallCol+3;j++){
                if(sdoku[i][j]==num){
                    return false;
                }
            }
        }

        return true;
    }
    
}