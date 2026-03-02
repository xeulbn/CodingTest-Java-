import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    private static final int SUDOKU_ROW_SIZE = 9;
    private static final int SUDOKU_COL_SIZE = 9;
    public static int[][] sudoku;
    public static List<int[]> empties = new ArrayList<>();
    private static boolean solved= false;

    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sudoku=new int[SUDOKU_ROW_SIZE][SUDOKU_COL_SIZE];
        for(int i=0;i<SUDOKU_ROW_SIZE;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<SUDOKU_COL_SIZE;j++){
                sudoku[i][j]= Integer.parseInt(st.nextToken());
                if(sudoku[i][j]== 0){
                    empties.add(new int[]{i,j});
                }
            }
        }
        
        dfs(0);

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                sb.append(sudoku[r][c]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void dfs(int index){
        if(solved){
            return;
        }

        if(index==empties.size()){
            solved=true;
            return;
        }

        int[] pos = empties.get(index);
        int row = pos[0];
        int col = pos[1];

        for(int i=1;i<=9;i++){
            if(isValid(row,col,i)){
                sudoku[row][col]=i;
                dfs(index+1);
                if(solved){
                    return;
                }
                sudoku[row][col]=0;
            }
        }
    }

    public static boolean isValid(int row, int col, int num){
        for(int x=0;x<9;x++){
            if(sudoku[row][x]==num){
                return false;
            }
        }

        for(int x=0;x<9;x++){
            if(sudoku[x][col]==num){
                return false;
            }
        }

        int sr = (row/3)*3;
        int sc = (col/3)*3;
        
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(sudoku[i][j]==num)
                    return false;
            }
        }

        return true;
    }
}