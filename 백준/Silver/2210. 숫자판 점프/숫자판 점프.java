import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static int[][] map = new int[5][5];
    public static Set<String> number = new HashSet<>();
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        for(int i=0;i<5;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                dfs(i, j, String.valueOf(map[i][j]), 1);
            }
        }

        System.out.println(number.size());
    }

    public static void dfs(int x,int y,String str, int depth){
        if(depth==6){
            number.add(str);
            return;
        }

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx<0 || nx>=5 || ny<0 || ny>=5) 
                continue;

            dfs(nx, ny, str+map[nx][ny], depth+1);
        }
        
    }
}