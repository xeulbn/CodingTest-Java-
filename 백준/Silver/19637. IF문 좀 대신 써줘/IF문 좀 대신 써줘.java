import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int m;
    public static String[] name;
    public static int[] power;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());

        name =new String[n];
        power =new int[n];

        for(int i=0;i<n;i++){
            st= new StringTokenizer(br.readLine());
            name[i]= st.nextToken();
            power[i]= Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<m;i++){
            st= new StringTokenizer(br.readLine());
            int cha = Integer.parseInt(st.nextToken());
            int idx =lowerBound(power,cha);
            sb.append(name[idx]).append('\n');
        }
        System.out.println(sb.toString());

    }

    public static int lowerBound(int[] graph, int target){
        int low=0;
        int high=graph.length-1;
        int answer= graph.length-1;

        while(low<=high){
            int mid=(low+high)/2;
            if(graph[mid]>=target){
                answer=mid;
                high=mid-1;
            }else{
                low = mid + 1;
            }
        }
        return answer;
    }
}
