import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N= Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());

        arr= new int[N];

        long result = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<N;i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }

        int start=0;
        for(int i=0;i<N;i++){
            if(set.contains(arr[i])){
                for(int j=start;j<i;j++){
                    result+=i-j;
                    start++;
                    if(arr[j]==arr[i])
                        break;
                    set.remove(arr[j]);
                }
            }else{
                set.add(arr[i]);
            }
        }
        for(int i=start;i<N;i++){
            result+=N-i;
        }
        System.out.println(result);


    }
}
