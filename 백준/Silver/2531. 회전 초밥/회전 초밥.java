import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int d;
    public static int k;
    public static int c;
    public static int[] belt;
    public static boolean[] visit;
    public static int answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken()); // 벨트 위 접시의 갯수
        d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
        k = Integer.parseInt(st.nextToken()); //접시 수
        c = Integer.parseInt(st.nextToken()); //쿠폰번호
        belt=new int[n];

        answer =0;

        for(int i=0; i<n;i++){
            st = new StringTokenizer(br.readLine());
            belt[i]=Integer.parseInt(st.nextToken());
        }


        int max=0;

        for (int i=0;i<n;i++){
            visit=new boolean[d+1];
            int total =0;

            for(int j=0;j<k;j++){
                int index = (i + j) % n;
                int kind = belt[index];
                if(!visit[kind]){
                    visit[kind]=true;
                    total++;
                }
            }

            total = total+(visit[c]?0:1);
            max = Math.max(total,max);
        }

        System.out.println(max);

    }
}
