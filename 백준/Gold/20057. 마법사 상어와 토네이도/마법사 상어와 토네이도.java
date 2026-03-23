import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static int n;
    public static int[][] map;
    public static int[] dx = {0, 1, 0, -1};   // 좌, 하, 우, 상
    public static int[] dy = {-1, 0, 1, 0};
    public static int[] sx = {-1, 1, -1, 1, -1, 1, -2, 2, 0};
    public static int[] sy = { 1, 1, 0, 0, -1, -1, 0, 0, -2};
    public static int[] percent = {1, 1, 7, 7, 10, 10, 2, 2, 5};
    
    public static int answer = 0;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        //토네이도 형식은 좌하우상 순으로 움직이며 2번에 한번씩 카운트 수를 증가 시킨다. 증가시킨 카운트 만큼 앞으로 전진한다고 생각하고 구현
        moveTornado(n/2,n/2);

        System.out.println(answer);
        
    }

    public static void moveTornado(int x, int y){
        int len=1;
        int dir= 0; //0,1,2,3 => 좌하우상

        while(true){
            for(int i=0;i<2;i++){
                for(int j=0;j<len;j++){
                    x+=dx[dir];
                    y+=dy[dir];

                    spread(x, y, dir);

                    if (x==0 && y==0) {
                        return;
                    }
                }
                dir=(dir+1)%4;
            }
            len++;
        }
    }

    public static void spread(int x, int y, int dir){
        int morae = map[x][y];
        int remain = morae;

        for (int i = 0; i < 9; i++) {
            int nx = x + rotatedX(dir, sx[i], sy[i]);
            int ny = y + rotatedY(dir, sx[i], sy[i]);
    
            int moved = morae * percent[i] / 100;
            remain -= moved;
    
            if (isIn(nx, ny)) {
                map[nx][ny] += moved;
            }
            else {
                answer += moved;
            }
        }
    
        int ax = x + rotatedX(dir, 0, -1);
        int ay = y + rotatedY(dir, 0, -1);
    
        if (isIn(ax, ay)) {
            map[ax][ay] += remain;
        }
        else {
            answer += remain;
        }
    
        map[x][y] = 0;
    }

    public static int rotatedX(int dir, int rx, int ry) {
        if (dir == 0) {
            return rx; // 좌
        }
        if (dir == 1){ 
            return -ry; // 하
        }
        if (dir == 2) {
            return -rx;  // 우
        }
        
        return ry;  // 상
    }
    
    public static int rotatedY(int dir, int rx, int ry) {
        if (dir == 0) {
            return ry;// 좌
        }
        if (dir == 1) {
            return rx;  // 하
        }
        if (dir == 2) {
            return -ry; // 우
        }
        
        return -rx;  //상
    }

    public static boolean isIn(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }
    
}