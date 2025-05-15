import java.io.*;
import java.util.*;


public class Main {

    public static int n;
    public static int[] remember;
    
    public static void main(String[] args) throws Exception{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());

        remember=new int[n];
        for(int i=0;i<n;i++){
            remember[i]=Integer.parseInt(st.nextToken());
        }
        int[] answer= new int[n];

        for(int i=0;i<n;i++){
            int index=0;
            while(true){
                if(remember[i]==0&&answer[index]==0){
                    answer[index]=i+1;
                    break;
                }else if(answer[index]==0){
                    remember[i]--;
                }
                index++;
            }
        }

        for(int i=0;i<n;i++){
            System.out.print(answer[i]+" ");
        }
    }

}
