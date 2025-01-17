import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int N;
    public static int[] snowman;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        snowman=new int[N];

        for(int i=0;i<N;i++) {
            snowman[i] = Integer.parseInt(st.nextToken());
        }


        int minLen=Integer.MAX_VALUE;
        Arrays.sort(snowman);

        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                int snowDiameter1=snowman[i]+snowman[j];
                int start=0;
                int end = N-1;
                while(start<end){
                    if(start==i||start==j){
                        start++;
                        continue;
                    }
                    if(end ==i || end==j){
                        end--;
                        continue;
                    }
                    int snowDiameter2=snowman[start]+snowman[end];
                    minLen=Math.min(minLen,Math.abs(snowDiameter1-snowDiameter2));

                    if(snowDiameter1>snowDiameter2){
                        start++;
                    }else if(snowDiameter1<snowDiameter2){
                        end--;
                    }else{
                        System.out.println(0);
                        return;
                    }
                }
            }
        }
        
        System.out.println(minLen);

    }
}
