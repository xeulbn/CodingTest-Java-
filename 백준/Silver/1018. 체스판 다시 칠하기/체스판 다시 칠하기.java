import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static char[][] map;
    public static boolean[][] visited;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        map=new char[n][m];
        visited=new boolean[n][m];

        for(int i=0;i<n;i++){
            String line = br.readLine();
            for(int j=0;j<m;j++){
                map[i][j]=line.charAt(j);
            }
        }

        int answer =Integer.MAX_VALUE;
        
        for(int i=0;i<=n-8;i++){
            for(int j=0;j<=m-8;j++){
                int repaintW = countRepaint(i,j,'W');
                int repaintB = countRepaint(i,j,'B');
                answer = Math.min(answer, Math.min(repaintW,repaintB));
            }
        }
        
        System.out.println(answer);
    }

    public static int countRepaint(int startX,int startY, char startColor){
        int cnt=0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                char expected = ((i + j) % 2 == 0) ? startColor : opposite(startColor);

                if(map[startX+i][startY+j]!=expected){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static char opposite(char c){
        return c=='W' ? 'B':'W';
    }
}