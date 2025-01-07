import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int K;
    public static int[] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr=new int[K+1];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<K;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;

        for(int i=0;i<K;i++){
            if(list.contains(arr[i]))
                continue;
            if(list.size()<N){
                list.add(arr[i]);
                continue;
            }

            PriorityQueue<int[]>queue=new PriorityQueue<>((a,b)->b[1]-a[1]);

            for(int j=0;j<list.size();j++){
                int[] tmp=new int[2];
                tmp[0]=list.get(j);
                tmp[1]=101;
                int index=-1;

                for(int s=i;s<K;s++){
                    if(arr[s]==tmp[0]){
                        index=s;
                        break;
                    }
                }
                if(index!=-1)
                    tmp[1]=index;
                queue.add(tmp);
            }

            list.remove(list.indexOf(queue.poll()[0]));
            list.add(arr[i]);
            count++;
        }
        System.out.println(count);


    }
}
