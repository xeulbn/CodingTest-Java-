import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.*;

class Main {

    public static int n;
    public static int[][] chess;
    public static int answer=0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());

        chess= new int[n][n];
        dfs(0);

        System.out.println(answer);
    }

    public static void dfs(int row){
        if(row==n){
            answer++;
            return;
        }

        for(int col=0;col<n;col++){
            if(isPossible(row,col)){
                chess[row][col]=1;
                dfs(row+1);
                chess[row][col]=0;
            }
        }
    }

    public static boolean isPossible(int row, int col){
        for(int r=0;r<row;r++){
            if(chess[r][col]==1){
                return false;
            }
        }

        for(int r=row-1,c=col-1;r>=0&&c>=0;r--,c--){
            if(chess[r][c]==1){
                return false;
            }
        }

        for(int r=row-1,c=col+1;r>=0&&c<n;r--,c++){
            if(chess[r][c]==1){
                return false;
            }
        }

        return true;
    }
    
}