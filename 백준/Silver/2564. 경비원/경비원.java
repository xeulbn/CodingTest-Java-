import java.io.*;
import java.util.*;

public class Main {

    public static int width;
    public static int height;
    public static int storeCount;
    public static int[][] store;
    public static int perimeter;

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        width=Integer.parseInt(st.nextToken());
        height=Integer.parseInt(st.nextToken());
        perimeter=(width+height)*2;

        st=new StringTokenizer(br.readLine());
        storeCount=Integer.parseInt(st.nextToken());

        store=new int[storeCount+1][2];
        for(int i=0;i<storeCount;i++){
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            store[i][0] = direction;
            store[i][1] = distance;
        }
        st = new StringTokenizer(br.readLine());
        store[storeCount][0] = Integer.parseInt(st.nextToken());
        store[storeCount][1] = Integer.parseInt(st.nextToken());


        int pos=toLinear(store[storeCount][0], store[storeCount][1]);

        int total =0;

        for(int i=0;i<storeCount;i++){
            int storePos = toLinear(store[i][0], store[i][1]);
            int dist = Math.abs(pos - storePos);
            total += Math.min(dist, perimeter - dist);
        }
        System.out.println(total);




    }

    public static int toLinear(int dir, int dist){
        if(dir==1){
            return dist;
        }else if(dir==2){
            return width+height+(width-dist);
        }else if (dir==3){
            return 2*width+height+(height-dist);
        }
        return width+dist;
    }
}
