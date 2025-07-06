import java.io.*;
import java.util.*;

public class Main {

    public static int[][] sticker;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer=0;

        int h=Integer.parseInt(st.nextToken());
        int w= Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        sticker= new int[n][2];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            sticker[i][0]= Integer.parseInt(st.nextToken());
            sticker[i][1]= Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int h1=sticker[i][0];
                int w1=sticker[i][1];
                int h2=sticker[j][0];
                int w2=sticker[j][1];
                int size=w1 * h1 + w2 * h2;

                if(h1+h2<=w && Math.max(w1,w2)<=h){
                    answer=Math.max(answer,size);
                }

                if(h1+w2<=w&&Math.max(w1,h2)<=h){
                    answer=Math.max(answer,size);
                }

                if(w1+w2<=w&&Math.max(h1,h2)<=h){
                    answer=Math.max(answer,size);
                }

                if(w1+h2<=w&&Math.max(h1,w2)<=h){
                    answer=Math.max(answer,size);
                }

                if(Math.max(h1,h2)<=w&&w1+w2<=h){
                    answer=Math.max(answer,size);
                }

                if(Math.max(h1,w2)<=w&&w1+h2<=h){
                    answer=Math.max(answer,size);
                }
                if(Math.max(w1,w2)<=w&&h1+h2<=h){
                    answer=Math.max(answer,size);
                }
                if(Math.max(w1,h2)<=w&&h1+w2<=h){
                    answer=Math.max(answer,size);
                }

            }
        }

        System.out.println(answer);
    }
}
