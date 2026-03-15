import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static int n;
    public static int answer;
    public static int[][] chess;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        chess=new int[n][n];

        answer=0;
        dfs(0);
        System.out.println(answer);
    }


    public static void dfs(int depth){
        if(depth==n){
            answer++;
            return;
        }

        for(int col=0;col<n;col++){
            if(isPossible(depth,col)){
                chess[depth][col]=1;
                dfs(depth+1);
                chess[depth][col]=0;
            }
        }
    }

    public static boolean isPossible(int x, int y){
        for(int i=0;i<x;i++){
            if(chess[i][y]==1){
                return false;
            }
        }

        for(int i=x-1, j=y-1; i>=0&&j>=0 ; i--,j--){
            if(chess[i][j]==1){
                return false;
            }
        }

        for(int i=x-1,j=y+1;i>=0&&j<n;i--,j++){
            if(chess[i][j]==1){
                return false;
            }
        }
        return true;
    }
    

}