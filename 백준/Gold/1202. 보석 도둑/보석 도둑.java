import java.io.*;
import java.util.*;

public class Main {

    private static int n;
    private static int k;

    private static int[] bag;

    private static PriorityQueue<Integer> pq;

    private static class Jewel {
        int weight;
        int price;

        Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        Jewel[] jewels = new Jewel[n];
        bag = new int[k];

        for(int i=0;i<n;i++) {
            st=new StringTokenizer(br.readLine());
            int weight= Integer.parseInt(st.nextToken());
            int price= Integer.parseInt(st.nextToken());
            jewels[i]=new Jewel(weight,price);
        }

        for(int i=0;i<k;i++){
            st=new StringTokenizer(br.readLine());
            bag[i]= Integer.parseInt(st.nextToken());
        }
        Arrays.sort(jewels, (a, b) -> a.weight - b.weight);
        Arrays.sort(bag);
        pq= new PriorityQueue<>(Collections.reverseOrder());

        int index=0;
        long answer=0;
        for(int i=0;i<k;i++) {

            while (index < n && jewels[index].weight <= bag[i]) {
                pq.offer(jewels[index].price);
                index++;
            }

            if(!pq.isEmpty()){
                answer+=pq.poll();
            }

        }
        System.out.println(answer);
    }
}
