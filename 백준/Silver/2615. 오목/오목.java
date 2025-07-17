import java.io.*;
import java.util.*;

public class Main {

    public static int[][] map;
    public static int[] dx = {0,1,1,-1};
    public static int[] dy = {1,1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map=new int[19][19];

        for(int i=0;i<19;i++){
            st=new StringTokenizer(br.readLine());
            for (int j=0;j<19;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<19;i++){
            for(int j=0;j<19;j++){
                if(map[i][j]!=0){
                    for(int d=0;d<4;d++){
                        if(isValid(i,j,d,map[i][j])){
                            System.out.println(map[i][j]);
                            System.out.println((i+1)+" "+(j+1));
                            return;
                        }
                    }
                }
            }
        }

        System.out.println(0);

    }

    public static boolean isValid(int x,int y,int d,int color){
        int count=1;
        int curX=x;
        int curY=y;

        for(int i=0;i<4;i++){
            curX+=dx[d];
            curY+=dy[d];

            if(curX<0||curX>=19||curY<0||curY>=19||map[curX][curY]!=color){
                break;
            }
            count++;
        }

        int backX=x-dx[d];
        int backY=y-dy[d];
        if(backX>=0&& backX<19 &&backY>=0&&backY<19&&map[backX][backY]==color){
            return false;
        }

        int falseX=curX+dx[d];
        int falseY=curY+dy[d];

        if(falseX>=0&&falseX<19&&falseY>=0&&falseY<19&&map[falseX][falseY]==color){
            return false;
        }

        return count==5;
    }
}
