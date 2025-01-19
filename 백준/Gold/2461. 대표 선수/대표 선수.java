import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int M;
    public static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        map= new int[N][M];

        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            Arrays.sort(map[i]);
        }

        int arr[] = new int[N];
        int result = Integer.MAX_VALUE;
        int minArray=0;
        while(true){
            int max=0;
            int min=Integer.MAX_VALUE;
            for(int i=0;i<N;i++){
                if(map[i][arr[i]]>max){
                    max=map[i][arr[i]];
                }
                if(map[i][arr[i]]<min){
                    min=map[i][arr[i]];
                    minArray=i;
                }
            }

            result = Math.min(result, max-min);
            arr[minArray]++;
            if(arr[minArray]==M){
                break;
            }
        }
        System.out.println(result);

    }
}
