import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int t;
    public static int n;
    public static int[][] location;
    public static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        t=Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++){
            n=Integer.parseInt(br.readLine());
            location=new int[n+2][2];
            visit=new boolean[n+2];

            StringTokenizer st= new StringTokenizer(br.readLine());
            location[0][0]=Integer.parseInt(st.nextToken());
            location[0][1]=Integer.parseInt(st.nextToken());

            for(int j=1;j<=n;j++){
                st= new StringTokenizer(br.readLine());
                location[j][0]=Integer.parseInt(st.nextToken());
                location[j][1]=Integer.parseInt(st.nextToken());
            }

            st=new StringTokenizer(br.readLine());
            location[n+1][0]=Integer.parseInt(st.nextToken());
            location[n+1][1]=Integer.parseInt(st.nextToken());

            if(bfs()){
                sb.append("happy\n");
            }else{
                sb.append("sad\n");
            }

        }
        System.out.println(sb);
    }

    public static boolean bfs(){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        visit[0]=true;

        while(!queue.isEmpty()){
            int current = queue.poll();

            if(current==n+1){
                return true;
            }

            for(int next=0;next<n+2;next++){
                if(!visit[next]&&canReach(location[current],location[next])){
                    visit[next]=true;
                    queue.add(next);
                }
            }
        }
        return false;
    }

    public static boolean canReach(int[] from,int[] to){
        int distance=Math.abs(from[0]-to[0])+ Math.abs(from[1]-to[1]);
        return distance<=1000;
    }
}
