import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int m;
    public static int[] x;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine());
        m=Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine());
        x=new int[m];

        for(int i=0;i<m;i++){
            x[i]=Integer.parseInt(st.nextToken());
        }

        int distance= x[0];

        for(int i=0;i<m-1;i++){
            int mid = (x[i + 1] - x[i] + 1) / 2;
            distance = Math.max(distance, mid);
        }
        distance=Math.max(distance,n-x[m-1]);

        System.out.println(distance);
    }
}
