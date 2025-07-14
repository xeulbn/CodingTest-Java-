import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int[][] arr;
    public static int[][] dpMin;
    public static int[][] dpMax;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n=Integer.parseInt(br.readLine());
        arr = new int[n+1][3];
        dpMin = new int[n+1][3];
        dpMax = new int[n+1][3];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        dpMin[0][0]=arr[0][0];
        dpMin[0][1]=arr[0][1];
        dpMin[0][2]=arr[0][2];

        dpMax[0][0]=arr[0][0];
        dpMax[0][1]=arr[0][1];
        dpMax[0][2]=arr[0][2];

        for(int i=1;i<=n;i++){
            dpMin[i][0]=Math.min(dpMin[i-1][0],dpMin[i-1][1])+arr[i][0];
            dpMin[i][1]=Math.min(Math.min(dpMin[i-1][0],dpMin[i-1][1]),dpMin[i-1][2])+arr[i][1];
            dpMin[i][2]=Math.min(dpMin[i-1][1],dpMin[i-1][2])+arr[i][2];

            dpMax[i][0]=Math.max(dpMax[i-1][0],dpMax[i-1][1])+arr[i][0];
            dpMax[i][1]=Math.max(Math.max(dpMax[i-1][0],dpMax[i-1][1]),dpMax[i-1][2])+arr[i][1];
            dpMax[i][2]=Math.max(dpMax[i-1][1],dpMax[i-1][2])+arr[i][2];
        }

        int min=Math.min(Math.min(dpMin[n][0],dpMin[n][1]),dpMin[n][2]);
        int max= Math.max(Math.max(dpMax[n][0],dpMax[n][1]),dpMax[n][2]);

        System.out.println(max+" "+min);

    }
}
