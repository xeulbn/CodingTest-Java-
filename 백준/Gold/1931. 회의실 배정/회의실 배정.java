import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int[][] meetings;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        meetings = new int[N][2];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meetings, (o1, o2) -> {
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int cnt=0;
        int end=0;

        for(int i=0;i<N;i++){
            if(end<=meetings[i][0]){
                end=meetings[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);


    }

}
