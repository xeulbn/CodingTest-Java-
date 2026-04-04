import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static int n;
    public static int[][] condo;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());

        condo=new int[n][2];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            condo[i][0]=Integer.parseInt(st.nextToken());
            condo[i][1]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(condo,(a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });

        int candidate = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i=0; i<n; i++) {
            if (condo[i][1] < minPrice) {
                candidate++;
                minPrice = condo[i][1];
            }
        }

        System.out.println(candidate);
    }
}