import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int h;
    public static int w;
    public static int n;
    public static int m;
    public static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h=Integer.parseInt(st.nextToken());
        w=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        //인원 최대 수용이니까 다 갖다 수용해야되는데
        int row=0;
        int col=0;
        for(int i=0;i<w;i=i+m+1){
            row++;
        }

        for(int i=0;i<h;i=i+n+1){
            col++;
        }
        answer = row*col;
        System.out.println(answer);

    }
}
