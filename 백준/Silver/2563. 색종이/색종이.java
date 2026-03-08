import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static int n; //색종이 수
    public static int answer;
    public static boolean[][] paper;
        
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        paper = new boolean[101][101];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            checkBlack(x,y);
        }

        System.out.println(answer);
    }

    public static void checkBlack(int x, int y){
        for(int i=x;i<x+10;i++){
            for(int j=y;j<y+10;j++){
                if(!paper[i][j]){
                    paper[i][j]=true;
                    answer++;
                }
            }
        }
    }
}