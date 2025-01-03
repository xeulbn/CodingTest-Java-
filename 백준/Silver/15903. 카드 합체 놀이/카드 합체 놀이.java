import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int m;
    public static PriorityQueue<Long> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());

        pq= new PriorityQueue<>();

        st= new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            pq.add(Long.parseLong(st.nextToken()));
        }

        for(int i=0;i<m;i++){
            long sum = pq.poll()+pq.poll();
            pq.offer(sum);
            pq.offer(sum);
        }
        long answer=0;

        while(!pq.isEmpty()){
            answer+=pq.poll();
        }
        System.out.println(answer);


    }
}
