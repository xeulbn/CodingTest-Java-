import java.io.*;
import java.util.*;
public class Main {

    public static int N;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N= Integer.parseInt(st.nextToken());

        arr= new int[N][2];
        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            arr[i][0]= Integer.parseInt(st.nextToken());
            arr[i][1]= Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr,(o1,o2)->{
            if(o1[0]==o2[0]){
                return o1[1]-o2[1];
            }else{
                return o1[0]-o2[0];
            }
        });

        int x=arr[0][0];
        int y=arr[0][1];

        int len=y-x;
        for(int i=0;i<N;i++){
            if(x<=arr[i][0]&&arr[i][1]<=y){
                continue;
            }else if(arr[i][0]<y){
                len+=arr[i][1]-y;
            }else{
                len+=arr[i][1]-arr[i][0];
            }
            x=arr[i][0];
            y=arr[i][1];
        }
        System.out.println(len);

    }
}
