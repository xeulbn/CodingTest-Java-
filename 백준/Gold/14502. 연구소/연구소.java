import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static int[][] map;
    static List<Node> empties = new ArrayList<>();
    static List<Node> viruses = new ArrayList<>();
    static int answer = 0;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int n;
    public static int m;

    public static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map=new int[n][m];
        
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j]= Integer.parseInt(st.nextToken());
                if(map[i][j]==0){
                    empties.add(new Node(i,j));
                }else if(map[i][j]==2){
                    viruses.add(new Node(i,j));
                }
            }
        }

        int e = empties.size();

        for(int i=0;i<e;i++){
            for(int j=i+1;j<e;j++){
                for(int k=j+1;k<e;k++){
                    Node a = empties.get(i);
                    Node b = empties.get(j);
                    Node c = empties.get(k);
                    map[a.x][a.y]=1;
                    map[b.x][b.y]=1;
                    map[c.x][c.y]=1;

                    answer = Math.max(answer,simulateVirus());

                    map[a.x][a.y]=0;
                    map[b.x][b.y]=0;
                    map[c.x][c.y]=0;
                }
            }
        }
        System.out.println(answer);
    }

    public static int simulateVirus(){
        int[][] temp = copyMap(map);
        Queue<Node> queue = new ArrayDeque<>();

        for(Node v: viruses){
            queue.offer(new Node(v.x,v.y));
        }

        while(!queue.isEmpty()){
            Node curr = queue.poll();
            for(int dir=0;dir<4;dir++){
                int nextX=curr.x+dx[dir];
                int nextY=curr.y+dy[dir];

                if(nextX<0||nextX>=n||nextY<0||nextY>=m){
                    continue;
                }
                if(temp[nextX][nextY]!=0){
                    continue;
                }
                temp[nextX][nextY]=2;
                queue.offer(new Node(nextX,nextY));
            }
        }
        int safe = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(temp[i][j]==0)
                    safe++;
            }
        }
        return safe;
    }

    public static int[][] copyMap(int[][] source){
        int[][] tmp = new int [n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                tmp[i][j]=source[i][j];
            }
        }
        return tmp;
    }

    
}