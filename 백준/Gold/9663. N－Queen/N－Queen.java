import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.*;

class Main {

    public static int n;
    public static int[][] chess;
    public static int count=0;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        chess=new int[n][n];

        dfs(0);

        System.out.println(count);
    }

    public static void dfs(int depth){
        if(depth==n){
            count++;
            return;
        }
        for(int i=0;i<n;i++){
            if(possible(depth,i)){
                chess[depth][i]=1;
                dfs(depth+1);
                chess[depth][i]=0;
            }
        }
    }

    public static boolean possible(int row, int col){
        for(int i=0;i<row;i++){
            if(chess[i][col]==1){
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