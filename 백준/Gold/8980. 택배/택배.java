import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int C;
    public static int M;
    public static int[][] box;

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N= Integer.parseInt(st.nextToken());
        C= Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine());
        M= Integer.parseInt(st.nextToken());
        box=new int[M][3];

        for(int i=0;i<M;i++){
            st= new StringTokenizer(br.readLine());
            box[i][0]= Integer.parseInt(st.nextToken());
            box[i][1]= Integer.parseInt(st.nextToken());
            box[i][2]= Integer.parseInt(st.nextToken());
        }

        Arrays.sort(box,(a,b)->{
            if(a[1]==b[1]){
                return a[0]-b[0];
            }
            return a[1]-b[1];
        });

        int[] capacities = new int[N];
        for(int i=0;i<N;i++){
            capacities[i] = C;
        }

        int answer=0;
        for(int i=0;i<box.length;i++){
            int capacity = Integer.MAX_VALUE;
            for(int j=box[i][0];j<box[i][1];j++){
                capacity=Math.min(capacity,capacities[j]);
            }

            for(int j=box[i][0];j<box[i][1];j++){
                capacities[j]-=Math.min(capacity,box[i][2]);
            }

            answer+=Math.min(capacity,box[i][2]);

        }
        System.out.println(answer);
    }
}
