import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int w;
    public static int L;
    public static Queue<Integer> truck;
    public static Queue<Integer> bridge;

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        w=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());

        truck = new LinkedList<>();
        bridge = new LinkedList<>();

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            truck.add(Integer.parseInt(st.nextToken()));
        }
        for(int i=0;i<w;i++){
            bridge.add(0);
        }

        int time=0;
        int nowBridge=0;

        while(!bridge.isEmpty()){
            time++;
            nowBridge=nowBridge-bridge.poll();
            if(!truck.isEmpty()){
                if(truck.peek()+nowBridge<=L){
                    nowBridge+=truck.peek();
                    bridge.add(truck.poll());
                }else{
                    bridge.add(0);
                }
            }
        }
        System.out.println(time);


    }
}
